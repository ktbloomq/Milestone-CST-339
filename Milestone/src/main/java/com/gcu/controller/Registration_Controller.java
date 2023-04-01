package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.RegistrationService;
import com.gcu.model.RegisterModel;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/registration")
public class Registration_Controller {
	
	@Autowired
	private RegistrationService regService;
	
	/**
	 * Registration Controller that returns a view along with a Model Attribute
	 * @param model Model to bind to the view
	 * 
	 * @return View name registration
	 */
    @GetMapping("/")
    public String display(Model model) {
        model.addAttribute("title", "Registration");
        model.addAttribute("registerModel", new RegisterModel());
        return "registration";
    }
    
    
    /**
     * Handles the registration form submission and redirects the user to the login page if successful.
     *
     * @param registerModel the registration form model containing user input data
     * @param bindingResult the result of the validation process for the registration form model
     * @param model the Spring MVC model object used to pass data to the view
     * 
     * @return  view name redirect:/login/
     */
    @PostMapping("/doRegistration")
    public String doRegistration(@Valid RegisterModel registerModel, BindingResult bindingResult, Model model) {
    	System.out.printf("First Name: %s Last Name: %s Phone Num: %s Address: %s Email: %s Password: %s%n", registerModel.getFirstName(), registerModel.getLastName(), registerModel.getPhone(), registerModel.getAddress(), registerModel.getEmail(), registerModel.getPassword());
    	//Validation errors for Registration
    	
    	
    	
        if(bindingResult.hasErrors()) {
            model.addAttribute("title", "Registration Form");
            return "registration";
        }
        
        regService.register(registerModel);
        
        return "redirect:/login/";
    }
}