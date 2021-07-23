package com.example.ordercenter.service;

import com.example.ordercenter.model.ProductEntity;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "order-center")
@Service
public interface StockManagerService {

    @GetMapping("/orders/{id}")
    ProductEntity getProductStocksById(@Param("id") String id);

    @PutMapping("/orders/{id}")
    boolean updateProductStocksById(@Param("id") String id, @Param("product") ProductEntity productEntity);
}
