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
}
