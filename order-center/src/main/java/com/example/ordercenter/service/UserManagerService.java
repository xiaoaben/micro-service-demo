package com.example.ordercenter.service;

import com.example.ordercenter.model.UserEntity;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="user-center")
@Service
public interface UserManagerService {

    @GetMapping("/users/{id}")
    UserEntity getUserInfoById(@Param("id") String id);



}
