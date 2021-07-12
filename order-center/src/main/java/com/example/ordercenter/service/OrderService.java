package com.example.ordercenter.service;

import com.example.ordercenter.model.OrderEntity;

import java.util.List;

public interface OrderService {

    List<OrderEntity> getOrders(String userId);

    int addOrderInfo(OrderEntity orderEntity);
}
