package com.acmefresh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acmefresh.exception.ProductsException;
import com.acmefresh.model.ProductEnum;
import com.acmefresh.model.Products;
import com.acmefresh.repository.ProductsDao;

@Service
public class ProductsServiceImpl implements ProductsService{
	
	@Autowired
	private ProductsDao productsDao;

	@Override
	public Products addSingleProducts(Products product) {
		return productsDao.save(product);
	}

	@Override
	public List<Products> getAllProducts() {
		List<Products> products = productsDao.findAll();
		if(products.size()<=0) {
			throw new ProductsException("No Products found");
		}
		return products;
	}

	@Override
	public String deleteProductById(Integer productsId) {
		Optional<Products> opt = productsDao.findById(productsId);
		if(opt.isEmpty()) {
			throw new ProductsException("Product not found");
		}
		productsDao.delete(opt.get());
		return "deleted successfully";
	}

//	@Override
//	public String deleteProductsByCategory(String productsCategory) {
//		List<Products> products = productsDao.findByProductCategory(productsCategory);
//		System.out.println(products);
//		if(products.size()<=0) {
//			throw new ProductsException("No Products found");
//		}
//		for(Products product: products) {
//			productsDao.delete(product);
//		}
//		return "deleted successfully";
//	}

	@Override
	public Products updateProductsById(Integer productsId, Products product) {
		Optional<Products> opt = productsDao.findById(productsId);
		if(opt.isEmpty()) {
			throw new ProductsException("Product not found");
		}
		Products databaseProduct = opt.get();
		databaseProduct.setProductName(product.getProductName());
		databaseProduct.setProductCategory(product.getProductCategory());
		databaseProduct.setQuantity(product.getQuantity());
		databaseProduct.setPricePerKg(product.getPricePerKg());
		return productsDao.save(databaseProduct);
	}

}
