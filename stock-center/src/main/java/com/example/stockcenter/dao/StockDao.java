package com.example.stockcenter.dao;

import com.example.stockcenter.model.StockInformation;

import java.util.List;
import java.util.Optional;

public interface StockDao {

    Optional<StockInformation> getStockInfosByProductId(String id);

    List<StockInformation> getStockInfosBySql();

}
