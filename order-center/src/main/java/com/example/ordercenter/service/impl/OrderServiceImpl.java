package com.example.ordercenter.service.impl;

import com.example.ordercenter.Repository.OrderRepository;
import com.example.ordercenter.model.OrderEntity;
import com.example.ordercenter.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

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
     * 下单流程：
     * 1、先从库存中心查询商品剩余库存；
     * 2、从用户中心查询产品角色(vip..)确认用户是否有购买权限/计算折扣<正常应该在下单时计算>；
     * 步骤1、2使用线程池同时查询，结果处理后没问题，则进行支付，数据入库，下单完成。
     *
     * CountDownLatch vs CyclicBarrier
     * 线程池使用：java线程池动态配置调整？  线程池解决的核心问题就是资源管理问题
     * 考虑秒杀 使用redis 防止超卖
     */
    public boolean placeOrder(){





        return false;
    }


}
