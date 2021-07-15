package com.example.backstagemanagement.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="product-center")
@Service
public interface ProductManagerService {

    @GetMapping(value = "/products")
    String getProductInfos();

}
