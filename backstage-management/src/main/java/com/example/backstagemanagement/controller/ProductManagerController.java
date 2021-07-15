package com.example.backstagemanagement.controller;

import com.example.backstagemanagement.service.ProductManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductManagerController {

    @Autowired
    private ProductManagerService productManagerService;




}
