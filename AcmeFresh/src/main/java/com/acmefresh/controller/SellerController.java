package com.acmefresh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.acmefresh.model.Seller;
import com.acmefresh.service.SellerService;

@RestController
public class SellerController {
	@Autowired
	private SellerService sellerService;
	
	@PostMapping("/seller")
	public ResponseEntity<Seller> registerCustomerController(@RequestBody Seller seller){
		Seller savedSeller = sellerService.registerSeller(seller);
		return new ResponseEntity<Seller>(savedSeller, HttpStatus.CREATED);
	}
	
	@PutMapping("/seller/{sellerId}")
	public ResponseEntity<Seller> updateSellerDetailsController(@RequestBody Seller seller,@PathVariable("sellerId") Integer sellerId){
		Seller savedSeller = sellerService.updateSellerDetails(seller, sellerId);
		return new ResponseEntity<Seller>(savedSeller, HttpStatus.ACCEPTED);
	}
}
