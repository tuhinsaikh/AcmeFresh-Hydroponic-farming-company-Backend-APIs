package com.acmefresh.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acmefresh.model.ServicesOrder;

@Repository
public interface ServicesOrderDao extends JpaRepository<ServicesOrder, Integer>{
	Optional<ServicesOrder> findByCustomerId(Integer customerId);
}
