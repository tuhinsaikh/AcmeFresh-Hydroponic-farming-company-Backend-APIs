package com.acmefresh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acmefresh.model.Products;

@Repository
public interface ProductsDao extends JpaRepository<Products, Integer>{
//		List<Products> findByProductCategory(String productsCategory);
}
