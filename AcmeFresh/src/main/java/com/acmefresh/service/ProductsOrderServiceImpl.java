package com.acmefresh.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acmefresh.exception.CustomerException;
import com.acmefresh.exception.ProductsException;
import com.acmefresh.model.Customer;
import com.acmefresh.model.Products;
import com.acmefresh.model.ProductsOrder;
import com.acmefresh.repository.CustomerDao;
import com.acmefresh.repository.OrderedProducts;
import com.acmefresh.repository.ProductsDao;
import com.acmefresh.repository.ProductsOrderDao;

@Service
public class ProductsOrderServiceImpl implements ProductsOrderService{
	
	@Autowired
	private ProductsOrderDao productsOrderDao;
	
	@Autowired
	private ProductsDao productsDao;
	
	@Autowired
	private CustomerDao customerDao;
	@Override
	public ProductsOrder addProductsOrder(Integer customerId, List<Integer> productsId, List<Double> productsQuantity) {
		Optional<Customer> optCustomer = customerDao.findById(customerId);
		if(optCustomer.isEmpty()) {
			throw new CustomerException("customer does not exist");
		}
		for(int i = 0; i<productsId.size();i++) {
			Optional<Products> optProduct = productsDao.findById(productsId.get(i));
			if(optProduct.isEmpty()) {
				throw new ProductsException("product not found");
			}
			if(optProduct.get().getQuantity()<productsQuantity.get(i)) {
				throw new ProductsException("product quantity higher than stored product quantity");
			}
		}
		List<OrderedProducts> products = new ArrayList<>();
		
		for(int i = 0; i<productsId.size();i++) {
			Optional<Products> optProduct = productsDao.findById(productsId.get(i));
			Products product = optProduct.get();
			product.setQuantity(product.getQuantity()-productsQuantity.get(i));
			productsDao.save(product);
			OrderedProducts orderedProducts = new OrderedProducts(product.getProductName(), product.getProductCategory(),product.getPricePerKg(), productsQuantity.get(i));
			System.out.println(product);
			products.add(orderedProducts);
		}
		Optional<ProductsOrder> optOrder = productsOrderDao.findByCustomerId(customerId);
		if(optOrder.isPresent()) {
			List<OrderedProducts> productsOrdered =  optOrder.get().getProducts();
			for(OrderedProducts product : products) {
				productsOrdered.add(product);
			}
			optOrder.get().setProducts(productsOrdered);
			optOrder.get().setLocalDateTime(LocalDateTime.now());
			return productsOrderDao.save(optOrder.get());
		}
		ProductsOrder order = new ProductsOrder();
		order.setCustomerId(customerId);
		order.setProducts(products);
		order.setLocalDateTime(LocalDateTime.now());
		return productsOrderDao.save(order);
	}
	@Override
	public ProductsOrder getOrderDetailsByCustomerId(Integer customerId) {
		Optional<ProductsOrder> optOrder = productsOrderDao.findByCustomerId(customerId);
		if(optOrder.isEmpty()) {
			throw new CustomerException("customer does not found");
		}
		return optOrder.get();
	}
	@Override
	public String deleteOrderByCustomerId(Integer customerId) {
		Optional<ProductsOrder> optOrder = productsOrderDao.findByCustomerId(customerId);
		if(optOrder.isEmpty()) {
			throw new CustomerException("customer does not found");
		}
		productsOrderDao.delete(optOrder.get());
		return "deleted successfully";
	}

}
