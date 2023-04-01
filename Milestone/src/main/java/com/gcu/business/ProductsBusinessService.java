package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import com.gcu.model.LoginModel;
import com.gcu.model.ProductModel;

public class ProductsBusinessService {

    public void test() {
        System.out.println("Hello from the OrdersBusinessService");
    }

    public List<ProductModel> getProducts() {
        List<ProductModel> products = new ArrayList<ProductModel>();
        products.add(new ProductModel(0, "Pixel 3a", 300));
        products.add(new ProductModel(1, "Pixel 4a", 400));
        products.add(new ProductModel(2, "Pixel 5a", 500));
        products.add(new ProductModel(3, "Pixel 6a", 600));
        return products;
    }

    public void init() {
        System.out.println("Initializing ProductsBusinessService :)");
    }

    public void destroy() {
        System.out.println("Destroying ProductsBusinessService :(");
    }
    
  //Authenticate user is in db
    public boolean authenticate(LoginModel lg) 
    {
    	if( lg.getEmail().equals("example@example.com") && lg.getPassword().equals("password123")) 
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
