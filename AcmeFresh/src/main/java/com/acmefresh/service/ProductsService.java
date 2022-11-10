package com.acmefresh.service;

import java.util.List;

import com.acmefresh.model.Products;

public interface ProductsService {
	
	//bySeller
	public Products addSingleProducts(Products product);
	
	//bySeller
	public Products updateProductsById(Integer productsId, Products product);
	
	//bySeller or byCustomer
	public List<Products> getAllProducts();
	
	//bySeller
	public String deleteProductById(Integer productsId);
	
//	//bySeller
//	public String deleteProductsByCategory(String productsCategory);

}
