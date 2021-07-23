package com.example.usercenter.service.impl;

import com.example.usercenter.dao.UserDao;
import com.example.usercenter.model.UserEntity;
import com.example.usercenter.service.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserManagerServiceImpl implements UserManagerService {

    @Autowired
    private UserDao userDao;

    @Override
    public Optional<UserEntity> getUserInfoById(String id) {
        return userDao.getUserInfoById(id);
    }

    @Override
    public boolean registerUser(UserEntity user) {
        return userDao.registerUser(user);
    }
}
