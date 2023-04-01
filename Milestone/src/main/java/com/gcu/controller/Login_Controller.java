package com.gcu.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.ProductsBusinessService;
import com.gcu.model.LoginModel;
import com.gcu.model.ProductModel;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/login")
public class Login_Controller {

    @Autowired 
    private ProductsBusinessService service;

	/**
	 * LoginController that returns a view along with a Model Attribute
	 * @param model Model to bind to the view
	 * 
	 * @return View name login
	 */
    @GetMapping("/")
    public String display(Model model) {
        model.addAttribute("title", "Login Form");
        model.addAttribute("loginModel", new LoginModel());
        return "login";
    }
    
    /**
     * Handles the login form submission and redirects the user to the orders page if successful.
     *
     * @param loginModel the login form model containing user input data
     * @param bindingResult the result of the validation process for the registration form model
     * @param model the Spring MVC model object used to pass data to the view
     * 
     * @return  view name orders
     */
    @PostMapping("/doLogin")
    public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {

        System.out.printf("username: %s password: %s%n", loginModel.getEmail(), loginModel.getPassword());
        if(bindingResult.hasErrors()) {
            model.addAttribute("title", "Login Form");
            return "login";
        }
        
        //Authenticate User
        if(!loginModel.authenticate()) {
            model.addAttribute("title", "Login Form");
            return "login";
        }
        
        List<ProductModel> products = service.getProducts();
        model.addAttribute("title", "My Products");
        model.addAttribute("products", products);

        return "products";

        // List<OrderModel> orders = service.getOrders();
        
        // model.addAttribute("title", "My Orders");
        // model.addAttribute("orders", orders);
        // return "orders";
    }
    
    
    
}
