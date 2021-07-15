package com.example.productcenter.dao;

import com.example.productcenter.model.entity.ProductEntity;

import java.util.List;

public interface ProductDao {

    List<ProductEntity> getStockInfosBySql();

}
