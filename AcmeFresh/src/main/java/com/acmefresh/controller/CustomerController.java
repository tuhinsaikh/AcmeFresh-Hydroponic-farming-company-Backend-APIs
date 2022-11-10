package com.acmefresh.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.acmefresh.model.Customer;
import com.acmefresh.model.Seller;
import com.acmefresh.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> registerCustomerController(Customer customer){
		Customer savedCustomer = customerService.registerCustomer(customer);
		return new ResponseEntity<Customer>(savedCustomer, HttpStatus.CREATED);
	}
	
	@PutMapping("/customer/{customerId}")
	public ResponseEntity<Customer> updateSellerDetailsController(@RequestBody Customer customer,@PathVariable("customerId") Integer customerId){
		Customer savedCustomer = customerService.updateSellerDetails(customer, customerId);
		return new ResponseEntity<Customer>(savedCustomer, HttpStatus.ACCEPTED);
	}

}
