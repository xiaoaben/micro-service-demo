package com.example.productcenter.dao.impl;

import com.example.productcenter.dao.ProductDao;
import com.example.productcenter.mapper.MyBatisProductMapper;
import com.example.productcenter.model.entity.ProductEntity;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Resource
    private MyBatisProductMapper myBatisProductMapper;

    @Override
    public List<ProductEntity> getStockInfosBySql() {
        String sql = "select * from product_entity";
        return myBatisProductMapper.getProductInfosBySql(sql);
    }
}
