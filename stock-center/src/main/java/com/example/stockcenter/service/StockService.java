package com.example.stockcenter.service;

import com.example.stockcenter.model.StockInformation;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public interface StockService {

    List<StockInformation> getStockInfos();

    AtomicInteger decreaseStock(String productId, int n);


}
