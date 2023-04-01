package com.gcu.business;

import com.gcu.model.RegisterModel;

public interface RegistrationServiceInterface {

	
	public RegisterModel register(RegisterModel registerModel);
	public void init();
	public void destroy();

}
