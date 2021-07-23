package com.example.ordercenter.repository;

import com.example.ordercenter.model.OrderEntity;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface OrderRepository extends Mapper<OrderEntity> {
}
