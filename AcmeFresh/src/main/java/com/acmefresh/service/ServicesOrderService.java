package com.acmefresh.service;

import com.acmefresh.model.ServicesOrder;

public interface ServicesOrderService {
	
	public ServicesOrder addServicesOrder(Integer customerId, String serviceType);
	public ServicesOrder getServiesOrderByCustomerId(Integer customerId);
	public String deleteServicesOrderByCustomerId(Integer customerId);

}
