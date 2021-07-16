package com.example.ordercenter.controller;

import com.example.ordercenter.model.OrderEntity;
import com.example.ordercenter.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final static Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    public List<OrderEntity> getOrders(@RequestParam("userId") String userId) {

        logger.info("[getOrders] userId:{}",userId);
        return orderService.getOrders(userId);
    }

}
