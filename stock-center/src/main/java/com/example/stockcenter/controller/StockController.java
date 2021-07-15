package com.example.stockcenter.controller;

import com.example.stockcenter.model.StockInformation;
import com.example.stockcenter.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/stocks")
    public List<StockInformation> getStockInfos() {
        return stockService.getStockInfos();
    }
}
