package com.example.productcenter.mapper;

import com.example.productcenter.dao.ProductDao;
import com.example.productcenter.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String>, ProductDao {
}
