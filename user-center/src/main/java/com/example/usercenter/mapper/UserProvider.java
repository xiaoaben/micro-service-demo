package com.example.usercenter.mapper;

import org.apache.ibatis.jdbc.SQL;

public class UserProvider {

    private static final String USER_INFO = "user_info";

    public String getUserInfoById() {
        String sql = new SQL() {
            {
                SELECT("id", "name", "pwd", "alias", "describe", "credit", "type", "vip", "create_at", "update_at");
                FROM(USER_INFO);
                WHERE("id=#{id}");
                ORDER_BY("create_at");
            }
        }.toString();
        sql += "limit 1";
        return sql;
    }

    public String registerUser() {
        return new SQL() {
            {
                INSERT_INTO(USER_INFO);
                VALUES("id", "#{id}");
                VALUES("name", "#{name}");
                VALUES("pwd", "#{pwd}");
                VALUES("alias", "#{alias}");
                VALUES("describe", "#{describe}");
                VALUES("credit", "#{credit}");
                VALUES("type", "#{type}");
                VALUES("vip", "#{vip}");
                VALUES("create_at", "#{createTime}");
                VALUES("update_at", "#{updateTime}");
            }
        }.toString();
    }
}
