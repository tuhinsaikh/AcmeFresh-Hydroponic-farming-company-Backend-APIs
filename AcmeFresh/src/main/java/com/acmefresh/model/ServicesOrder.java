package com.acmefresh.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ServicesOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer serviceOrderId;
	@Column(unique = true)
	private Integer customerId;
	@Enumerated(EnumType.STRING)
	private ServiceEnum serviceType;
	
	private LocalDateTime localDateTime;

	public ServicesOrder(Integer customerId, ServiceEnum serviceType, LocalDateTime localDateTime) {
		super();
		this.customerId = customerId;
		this.serviceType = serviceType;
		this.localDateTime = localDateTime;
	}
	
	
}
