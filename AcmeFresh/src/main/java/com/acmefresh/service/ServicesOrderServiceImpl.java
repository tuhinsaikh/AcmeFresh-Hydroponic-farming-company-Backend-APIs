package com.acmefresh.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acmefresh.exception.CustomerException;
import com.acmefresh.model.Customer;
import com.acmefresh.model.ServiceEnum;
import com.acmefresh.model.ServicesOrder;
import com.acmefresh.repository.CustomerDao;
import com.acmefresh.repository.ServicesOrderDao;

@Service
public class ServicesOrderServiceImpl implements ServicesOrderService{
	
	@Autowired
	private ServicesOrderDao servicesOrderDao;
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public ServicesOrder addServicesOrder(Integer customerId, String serviceType) {
		Optional<Customer> optCustomer = customerDao.findById(customerId);
		if(optCustomer.isEmpty()) {
			throw new CustomerException("customer does not exist");
		}
		
		if(serviceType.equalsIgnoreCase(ServiceEnum.INFRASTRUCTURE.toString())) {
			ServicesOrder servisesOrder = new ServicesOrder(customerId, ServiceEnum.INFRASTRUCTURE, LocalDateTime.now());
			return servicesOrderDao.save(servisesOrder);
		}else if(serviceType.equalsIgnoreCase(ServiceEnum.MODERN_TECHNIQUES.toString())){
			ServicesOrder servisesOrder = new ServicesOrder(customerId, ServiceEnum.MODERN_TECHNIQUES, LocalDateTime.now());
			return servicesOrderDao.save(servisesOrder);
		}else {
			throw new CustomerException("service does not found");
		}
	}

	@Override
	public ServicesOrder getServiesOrderByCustomerId(Integer customerId) {
		Optional<ServicesOrder> optService = servicesOrderDao.findByCustomerId(customerId);
		if(optService.isEmpty()) {
			throw new CustomerException("order not found");
		}
		return optService.get();
	}

	@Override
	public String deleteServicesOrderByCustomerId(Integer customerId) {
		Optional<ServicesOrder> optService = servicesOrderDao.findByCustomerId(customerId);
		if(optService.isEmpty()) {
			throw new CustomerException("order not found");
		}
		servicesOrderDao.delete(optService.get());
		return "deleted successfully";
	}

}
