package com.gcu.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoginModel {

    @NotNull(message = "enter email")
    @Size(max = 32, message = "email is too long")
    private String email;
    
    @NotNull(message = "enter password")
    @Size(min = 10, max = 32, message = "password must be between 10 and 32 characters")
    private String password;

    public String getEmail() {
        return email;
    }
    public void setEmail (String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
  //Authenticate user is in db
    public boolean authenticate() 
    {
    	if(getEmail().equals("example@example.com") && getPassword().equals("password123")) 
    	{
    		System.out.println("Successfully authenticated");
    		return true;
    	}
    	else {
    		System.out.println("No existing users found");
    		return false;
    	}
		
    }
}
