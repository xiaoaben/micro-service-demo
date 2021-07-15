package com.example.stockcenter.service.impl;

import com.example.stockcenter.mapper.MessageRepository;
import com.example.stockcenter.model.StockInformation;
import com.example.stockcenter.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public List<StockInformation> getStockInfos() {
        return messageRepository.getStockInfosBySql();
    }

    /**
     * AtomicInteger: 非阻塞算法实现并发控制,提供原子操作来进行Integer的使用，适合高并发
     *
     * 适用场景：
     *        1.作为多个线程同时使用的原子计数器；
     *        2.在比较和交换操作中实现非阻塞算法。
     */
    @Override
    public AtomicInteger decreaseStock(String productId, int n) {

        Optional<StockInformation> stockInformationOpt = messageRepository.getStockInfosByProductId(productId);
        stockInformationOpt.ifPresent(stockInformation -> {

            Integer amount = stockInformation.getAmount();
            AtomicInteger atomicInteger = new AtomicInteger(amount);
            for (int i =0 ;i < n;i++){
                atomicInteger.getAndDecrement();
            }
            stockInformation.setAmount(atomicInteger.get());
            messageRepository.save(stockInformation);
        });
        return null;
    }


}
