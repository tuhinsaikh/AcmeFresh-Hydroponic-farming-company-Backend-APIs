package com.acmefresh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderedProductsDao extends JpaRepository<OrderedProducts, Integer>{

}
