package com.acmefresh.service;

import com.acmefresh.model.Seller;

public interface SellerService {
	public Seller registerSeller(Seller seller); 
	public Seller updateSellerDetails(Seller seller, Integer sellerId);
}
