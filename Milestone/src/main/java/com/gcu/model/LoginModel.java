package com.gcu.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    public boolean authenticate() throws SQLException 
    {
    	
    	
    	/*if(getEmail().equals("example@example.com") && getPassword().equals("password123")) 
    	{
    		System.out.println("Successfully authenticated");
    		return true;
    	}
    	else {
    		System.out.println("No existing users found");
    		return false;
    	}*/
    	
    	
    	String email = getEmail();
    	String password = getPassword();

    	String jdbcUrl = "jdbc:mysql://localhost:3306/cst339";
    	boolean flag = false;
    	try(Connection connection = DriverManager.getConnection(jdbcUrl,"root","root")) {
    		 Statement statement = connection.createStatement();
	    	String query = "SELECT * fROM customers WHERE email='" + email + "' and password='" + password + "'";
	    	ResultSet rs = statement.executeQuery(query);
	    	while (rs.next()) 
	    	{
	    		String temail = rs.getString("email");
	            String tpassword =  rs.getString("password");
	            if ((email.equals(temail)) && (password.equals(tpassword))) {
	
	                System.out.println("Successfully authenticated");
	                flag = true;
	            }
	    	} 
	    	if(!flag) {
	    		
	    		System.out.println("Please check Email and Password");
	    	}
	    	rs.close();
    	}
    	catch(SQLException sql) {
    		 System.out.println(sql);
    	}
    	return flag;
    
    }
}
