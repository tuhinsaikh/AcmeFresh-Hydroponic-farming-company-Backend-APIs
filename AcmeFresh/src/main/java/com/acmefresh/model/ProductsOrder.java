package com.acmefresh.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.acmefresh.repository.OrderedProducts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductsOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productOrderId;
	@Column(unique = true)
	private Integer customerId;
	
	private LocalDateTime localDateTime;
	
	@OneToMany(cascade = CascadeType.ALL)
	List<OrderedProducts> products = new ArrayList<>();
	
	
}
