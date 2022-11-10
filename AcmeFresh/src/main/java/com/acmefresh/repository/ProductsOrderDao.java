package com.acmefresh.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acmefresh.model.ProductsOrder;

@Repository
public interface ProductsOrderDao extends JpaRepository<ProductsOrder, Integer>{
	Optional<ProductsOrder> findByCustomerId(Integer customerId);
}
