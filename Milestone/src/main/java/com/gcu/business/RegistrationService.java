package com.gcu.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.UsersDataSevice;
import com.gcu.data.entity.UserEntity;

@Service
public class RegistrationService {
	
	@Autowired
	UsersDataSevice service;

	
	/** 
	 * @param user
	 * @return UserEntity
	 */
	public UserEntity register(UserEntity user) {
		//Add registerModel to database
		service.create(user);
		System.out.println("Successfully registered");
		return null;
	}
}
