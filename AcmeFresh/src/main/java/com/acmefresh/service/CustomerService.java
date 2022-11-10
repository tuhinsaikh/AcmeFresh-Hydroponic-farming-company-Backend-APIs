package com.acmefresh.service;

import com.acmefresh.model.Customer;

public interface CustomerService {
	
	public Customer registerCustomer(Customer customer); 
	public Customer updateSellerDetails(Customer customer, Integer customerId);

}
