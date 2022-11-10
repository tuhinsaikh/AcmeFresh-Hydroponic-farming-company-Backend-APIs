package com.acmefresh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acmefresh.model.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>{
	
}
