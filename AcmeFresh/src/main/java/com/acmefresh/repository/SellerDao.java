package com.acmefresh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acmefresh.model.Seller;
@Repository
public interface SellerDao extends JpaRepository<Seller, Integer>{

}
