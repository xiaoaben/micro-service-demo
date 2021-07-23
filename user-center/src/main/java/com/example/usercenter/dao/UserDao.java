package com.example.usercenter.dao;

import com.example.usercenter.model.UserEntity;

import java.util.Optional;

public interface UserDao {

    boolean registerUser(UserEntity user);

    Optional<UserEntity> getUserInfoById(String id);
}
