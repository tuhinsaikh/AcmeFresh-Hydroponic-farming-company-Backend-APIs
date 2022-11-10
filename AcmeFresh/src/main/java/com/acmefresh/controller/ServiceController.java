package com.acmefresh.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.acmefresh.model.ServicesOrder;
import com.acmefresh.service.ServicesOrderService;

@RestController
public class ServiceController {
	
	@Autowired
	private ServicesOrderService servicesOrderService;
	
	@PostMapping("/servicesOrder/{customerId}")
	public ResponseEntity<ServicesOrder> addServicesOrderController(@PathVariable("customerId") Integer customerId, @RequestParam String serviceType){
		ServicesOrder order = servicesOrderService.addServicesOrder(customerId, serviceType);
		return new ResponseEntity<ServicesOrder>(order, HttpStatus.ACCEPTED);
	}

	@GetMapping("/servicesOrder/{customerId}")
	public ResponseEntity<ServicesOrder> getServiesOrderByCustomerIdController(@PathVariable("customerId") Integer customerId){
		ServicesOrder order = servicesOrderService.getServiesOrderByCustomerId(customerId);
		return new ResponseEntity<ServicesOrder>(order, HttpStatus.FOUND);
	}
	
	@DeleteMapping("/servicesOrder/{customerId}")
	public ResponseEntity<String> deleteServicesOrderByCustomerIdController(@PathVariable("customerId") Integer customerId){
		String messege = servicesOrderService.deleteServicesOrderByCustomerId(customerId);
		return new ResponseEntity<String>(messege, HttpStatus.ACCEPTED);
	}

}
