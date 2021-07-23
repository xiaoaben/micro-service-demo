package com.example.usercenter.service;

import com.example.usercenter.model.UserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

import java.util.Optional;

@FeignClient(name="user-center")
@Service
public interface UserManagerService {

    Optional<UserEntity> getUserInfoById(String id);

    boolean registerUser(UserEntity user);




}
