package com.gcu.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.CustomersDataSevice;
import com.gcu.data.entity.CustomerEntity;

@Service
public class RegistrationService {
	
	@Autowired
	CustomersDataSevice service;

	public CustomerEntity register(CustomerEntity customer) {
		//Add registerModel to database
		service.create(customer);
		System.out.println("Successfully registered");
		return null;
	}
}
