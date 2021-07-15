package com.example.stockcenter.dao.impl;

import com.example.stockcenter.dao.StockDao;
import com.example.stockcenter.mapper.MyBatisStockMapper;
import com.example.stockcenter.model.StockInformation;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Repository
public class StockDaoImpl implements StockDao {

    @Resource
    MyBatisStockMapper myBatisStockMapper;

    @Override
    public List<StockInformation> getStockInfosBySql() {

        String sql = "select * from stock_information";
        return myBatisStockMapper.getStockInfosBySql(sql);
    }

    @Override
    public Optional<StockInformation> getStockInfosByProductId(String id) {

        String sql = "select * from stock_information where product_id=#{id}";
        return myBatisStockMapper.getStockInfosBySql(sql).stream().findFirst();
    }


}
