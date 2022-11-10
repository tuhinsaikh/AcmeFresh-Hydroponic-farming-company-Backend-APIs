package com.acmefresh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acmefresh.model.Customer;
import com.acmefresh.model.ProductsOrder;
import com.acmefresh.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> registerCustomerController(Customer customer){
//		System.out.println(customer);
		Customer savedCustomer = customerService.registerCustomer(customer);
		return new ResponseEntity<Customer>(savedCustomer, HttpStatus.CREATED);
	}

}
