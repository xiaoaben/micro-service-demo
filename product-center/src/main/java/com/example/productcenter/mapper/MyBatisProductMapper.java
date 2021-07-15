package com.example.productcenter.mapper;

import com.example.productcenter.model.entity.ProductEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MyBatisProductMapper {

    /**
     * 执行任意SELECT语句
     */
    @Select("${sql}")
    List<ProductEntity> getProductInfosBySql(@Param("sql") String sql);
}
