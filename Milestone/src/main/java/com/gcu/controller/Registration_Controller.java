package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.LoginModel;
import com.gcu.model.OrderModel;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/registration")
public class Registration_Controller {
    @GetMapping("/")
    public String display(Model model) {
        model.addAttribute("title", "Registration");
        model.addAttribute("loginModel", new LoginModel());
        return "registration";
    }
    
    @PostMapping("/doRegistration")
    public String doRegistration(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {

        //System.out.printf("username: %s password: %s%n", loginModel.getEmail(), loginModel.getPassword());
        if(bindingResult.hasErrors()) {
            model.addAttribute("title", "Registration Form");
            return "registration";
        }
        return "login";
    }
}