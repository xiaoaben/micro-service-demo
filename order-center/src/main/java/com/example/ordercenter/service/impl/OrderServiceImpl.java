package com.example.ordercenter.service.impl;

import com.example.ordercenter.model.OrderEntity;
import com.example.ordercenter.model.ProductEntity;
import com.example.ordercenter.model.UserEntity;
import com.example.ordercenter.repository.OrderRepository;
import com.example.ordercenter.service.OrderService;
import com.example.ordercenter.service.StockManagerService;
import com.example.ordercenter.service.UserManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final static Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserManagerService userManagerService;

    @Autowired
    private StockManagerService stockManagerService;

    @Qualifier("customizeThreadPool")
    @Autowired
    private Executor placeExecutor;


    @Override
    public List<OrderEntity> getOrders(String userId) {
        List<OrderEntity> orders = orderRepository.selectAll();
        return orders.stream().filter(order -> order.getUserId().equals(userId)).collect(Collectors.toList());
    }

    @Override
    public int addOrderInfo(OrderEntity orderEntity) {
        return orderRepository.insert(orderEntity);
    }

    /**
     * 下单流程<前提： 仅vip会员可购买></>：
     * 1、先从库存中心查询商品剩余库存；
     * 2、从用户中心查询产品角色(vip..)确认用户是否有购买权限/计算折扣<正常应该在下单时计算>；
     * 步骤1、2使用线程池同时查询，结果处理后没问题，则进行支付，数据入库，下单完成。
     * <p>
     * CountDownLatch vs CyclicBarrier
     * 线程池使用：java线程池动态配置调整？  线程池解决的核心问题就是资源管理问题
     * 考虑秒杀 使用redis 防止超卖
     * <p>
     * todo: 添加售卖策略等 使用设计模式
     */
    @Override
    public boolean placeOrder(String userId, String productId) {

        // 通过AtomicReference<V> 实现对象引用的原子更新
        AtomicReference<ProductEntity> productEntityAtomicReference = new AtomicReference<>();
        AtomicBoolean vip = new AtomicBoolean(false);

        // 使用多线程获取用户及库存等信息
        getRelatedInfo(userId, productId, vip, productEntityAtomicReference);

        ProductEntity productEntity = productEntityAtomicReference.get();
        if (vip.get() && productEntity != null && productEntity.getStock() > 0) {
            // 1. todo: 付款 (假设已完成付款，后续补充该功能)

            // 2. 下单完成，新增订单数据，同时更新库存
            orderRepository.insert(new OrderEntity(productId, userId));
            productEntityAtomicReference.getAndUpdate(xx -> {
                Integer stock = xx.getStock();
                xx.setStock(--stock);
                return xx;
            });
            return stockManagerService.updateProductStocksById(productId, productEntityAtomicReference.get());
        }
        return false;
    }

    /**
     * 使用多线程获取相关信息：用户信息及库存信息
     */
    private void getRelatedInfo(String userId, String productId, AtomicBoolean vip, AtomicReference<ProductEntity> productEntityAtomicReference) {

        CountDownLatch countDownLatch = new CountDownLatch(2);
        placeExecutor.execute(() -> {
            UserEntity userEntity = userManagerService.getUserInfoById(userId);
            vip.set(userEntity.isVip());
            countDownLatch.countDown();
        });

        placeExecutor.execute(() -> {
            ProductEntity productEntity = stockManagerService.getProductStocksById(productId);
            productEntityAtomicReference.set(productEntity);
            countDownLatch.countDown();
        });

        try {
            // Causes the current thread to wait until the latch has counted down to zero, unless the thread is interrupted.
            countDownLatch.await();
        } catch (InterruptedException e) {
            logger.error("[OrderServiceImpl-getRelatedInfo] countDownLatch.await() error : {}", e.getMessage());
        }
    }

}
