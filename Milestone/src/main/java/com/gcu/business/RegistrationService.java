package com.gcu.business;

import org.springframework.stereotype.Service;

import com.gcu.model.RegisterModel;

@Service
public class RegistrationService implements RegistrationServiceInterface
{
	
	@Override
	public RegisterModel register(RegisterModel registerModel) {
		//Add registerModel to database
		System.out.println("Successfully registered");
		return null;
	}

	@Override
	public void init() {
		System.out.println("Hello from init registration");
		
	}

	@Override
	public void destroy() {
		System.out.println("Hello from destroy registration");
		
	}

}
