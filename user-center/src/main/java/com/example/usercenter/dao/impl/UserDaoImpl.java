package com.example.usercenter.dao.impl;

import com.example.usercenter.dao.UserDao;
import com.example.usercenter.mapper.UserMapper;
import com.example.usercenter.model.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    private final static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean registerUser(UserEntity user) {

        try {
            return userMapper.registerUser(user) > 0;
        } catch (Exception e) {
            logger.error("[registerUser] userMapper.registerUser error: {}", e.getMessage());
            return false;
        }
    }

    @Override
    public Optional<UserEntity> getUserInfoById(String id) {

        try {
            return Optional.ofNullable(userMapper.getUserInfoById(id));
        } catch (Exception e) {
            logger.error("[getUserInfoById] userMapper.getUserInfoById error: {}", e.getMessage());
            return Optional.empty();
        }
    }
}
