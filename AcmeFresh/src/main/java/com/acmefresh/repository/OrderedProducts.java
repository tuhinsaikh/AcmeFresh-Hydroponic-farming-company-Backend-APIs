package com.acmefresh.repository;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.acmefresh.model.ProductEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderedProducts {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	
	private String productName;
	
	@Enumerated(EnumType.STRING)
	private ProductEnum productCategory;
	
	private double pricePerKg;
	
	private double quantity;

	public OrderedProducts(String productName, ProductEnum productCategory, double pricePerKg, double quantity) {
		super();
		this.productName = productName;
		this.productCategory = productCategory;
		this.pricePerKg = pricePerKg;
		this.quantity = quantity;
	}

	
	
	
}
