package com.example.stockcenter.mapper;

import com.example.stockcenter.model.StockInformation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface MyBatisStockMapper {

    /**
     * 执行任意SELECT语句
     */
    @Select("${sql}")
    List<StockInformation> getStockInfosBySql(@Param("sql") String sql);

    @Update("{sql}")
    StockInformation updateStockInformation(@Param("sql") String sql);
}
