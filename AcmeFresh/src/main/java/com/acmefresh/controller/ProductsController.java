package com.acmefresh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.acmefresh.model.Products;
import com.acmefresh.service.ProductsService;



@RestController
public class ProductsController {
	
	@Autowired
	private ProductsService productsService;
	
	@PostMapping("/product")
	public ResponseEntity<Products> addSingleProductsController(@RequestBody Products product){
		Products savedProduct = productsService.addSingleProducts(product);
		return new ResponseEntity<Products>(savedProduct, HttpStatus.CREATED);
	}
	
	@PutMapping("/product/{productId}")
	public ResponseEntity<Products> updateProductsByIdController(@PathVariable("productId") Integer productId, @RequestBody Products product){
		Products savedProduct = productsService.updateProductsById(productId, product);
		return new ResponseEntity<Products>(savedProduct, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/product/{productId}")
	public ResponseEntity<String> deleteProductByIdController(@PathVariable("productId") Integer productId){
		String messege = productsService.deleteProductById(productId);
		return new ResponseEntity<String>(messege, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<Products>> getAllProductsController(){
		List<Products> savedProducts = productsService.getAllProducts();
		return new ResponseEntity<List<Products>>(savedProducts, HttpStatus.CREATED);
	}
	
//	@DeleteMapping("/product/{productsCategory}")
//	public ResponseEntity<String> deleteProductsByCategoryController(@PathVariable("productsCategory") String productsCategory){
//		String messege = productsService.deleteProductsByCategory(productsCategory);
//		return new ResponseEntity<String>(messege, HttpStatus.ACCEPTED);
//	}
	
	
}
