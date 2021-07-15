package com.example.productcenter.service.impl;

import com.example.productcenter.mapper.ProductRepository;
import com.example.productcenter.model.entity.ProductEntity;
import com.example.productcenter.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductEntity> getProductInfos() {
        return productRepository.getStockInfosBySql();
    }
}
