package com.example.stockcenter.mapper;

import com.example.stockcenter.dao.StockDao;
import com.example.stockcenter.model.StockInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<StockInformation, Long>, StockDao {

}
