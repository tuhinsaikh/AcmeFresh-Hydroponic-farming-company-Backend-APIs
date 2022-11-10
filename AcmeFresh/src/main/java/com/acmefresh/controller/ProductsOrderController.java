package com.acmefresh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acmefresh.model.ProductsOrder;
import com.acmefresh.service.ProductsOrderService;

@RestController
public class ProductsOrderController {
	
	@Autowired
	private ProductsOrderService productsOrderService;
	
	@PostMapping("/productsOrder/{customerId}")
	public ResponseEntity<ProductsOrder> addProductsOrderController(@PathVariable("customerId") Integer customerId,@RequestParam  List<Integer> productsId, @RequestParam List<Double> productsQuantity){
		ProductsOrder order = productsOrderService.addProductsOrder(customerId, productsId,productsQuantity);
		return new ResponseEntity<ProductsOrder>(order, HttpStatus.ACCEPTED);
	}

	@GetMapping("/productsOrder/{customerId}")
	public ResponseEntity<ProductsOrder> getOrderDetailsByCustomerIdController(@PathVariable("customerId") Integer customerId){
		ProductsOrder order = productsOrderService.getOrderDetailsByCustomerId(customerId);
		return new ResponseEntity<ProductsOrder>(order, HttpStatus.FOUND);
	}
	
	@DeleteMapping("/productsOrder/{customerId}")
	public ResponseEntity<String> deleteOrderByCustomerIdController(@PathVariable("customerId") Integer customerId){
		String messege = productsOrderService.deleteOrderByCustomerId(customerId);
		return new ResponseEntity<String>(messege, HttpStatus.ACCEPTED);
	}
}
