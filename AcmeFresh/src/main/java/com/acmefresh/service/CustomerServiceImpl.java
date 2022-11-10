package com.acmefresh.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acmefresh.exception.CustomerException;
import com.acmefresh.model.Customer;
import com.acmefresh.repository.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public Customer registerCustomer(Customer customer) {
		return customerDao.save(customer);
	}

}
