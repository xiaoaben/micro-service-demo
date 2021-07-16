package com.example.ordercenter.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

@FeignClient(name="user-center")
@Service
public interface UserManagerService {


}
