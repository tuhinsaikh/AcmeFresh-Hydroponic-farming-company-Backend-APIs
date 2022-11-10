package com.acmefresh.service;

import java.util.List;

import com.acmefresh.model.ProductsOrder;

public interface ProductsOrderService {
	
	public ProductsOrder addProductsOrder(Integer customerId, List<Integer> productsId,List<Double> productsQuantity);

	public ProductsOrder getOrderDetailsByCustomerId(Integer customerId);
	
	public String deleteOrderByCustomerId(Integer customerId);
}
