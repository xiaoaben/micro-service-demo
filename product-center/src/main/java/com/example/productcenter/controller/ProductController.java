package com.example.productcenter.controller;

import com.example.productcenter.model.entity.ProductEntity;
import com.example.productcenter.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<ProductEntity> getProductInfos() {
        return productService.getProductInfos();
    }


}
