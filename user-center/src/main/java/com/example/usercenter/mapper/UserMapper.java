package com.example.usercenter.mapper;

import com.example.usercenter.model.UserEntity;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @InsertProvider(type = UserProvider.class,method = "registerUser")
    int registerUser(UserEntity user) throws Exception;

    @SelectProvider(type = UserProvider.class,method = "getUserInfoById")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "update_at",property = "updateTime"),

    })
    UserEntity getUserInfoById(String id) throws Exception ;
}
