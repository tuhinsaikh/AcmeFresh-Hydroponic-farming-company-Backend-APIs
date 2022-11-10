package com.acmefresh.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acmefresh.exception.CustomerException;
import com.acmefresh.model.Customer;
import com.acmefresh.model.Seller;
import com.acmefresh.repository.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public Customer registerCustomer(Customer customer) {
		return customerDao.save(customer);
	}

	@Override
	public Customer updateSellerDetails(Customer customer, Integer customerId) {
		Optional<Customer> optCustomer = customerDao.findById(customerId);
		if(optCustomer.isEmpty()) {
			throw new CustomerException("Customer not found");
		}
		Customer savedCustomer = optCustomer.get();
		savedCustomer.setCustomerAddress(customer.getCustomerAddress());
		savedCustomer.setCustomerMobile(customer.getCustomerMobile());
		savedCustomer.setCustomerName(customer.getCustomerName());
		return customerDao.save(savedCustomer);
	}

}
