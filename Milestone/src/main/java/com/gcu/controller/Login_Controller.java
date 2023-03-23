package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gcu.model.LoginModel;
import com.gcu.model.OrderModel;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/login")
public class Login_Controller {

    @GetMapping("/")
    public String display(Model model) {
        model.addAttribute("title", "Login Form");
        model.addAttribute("loginModel", new LoginModel());
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {

        System.out.printf("username: %s password: %s%n", loginModel.getEmail(), loginModel.getPassword());
        if(bindingResult.hasErrors()) {
            model.addAttribute("title", "Login Form");
            return "login";
        }

        List<OrderModel> orders = new ArrayList<OrderModel>();
        orders.add(new OrderModel(0L, "0001", "Product 1", 1.00f, 1));
        orders.add(new OrderModel(1L, "0002", "Product 2", 2.00f, 2));
        orders.add(new OrderModel(2L, "0003", "Product 3", 3.00f, 3));
        orders.add(new OrderModel(3L, "0004", "Product 4", 4.00f, 4));
        orders.add(new OrderModel(5L, "0005", "Product 5", 5.00f, 5));
        
        model.addAttribute("title", "My Orders");
        model.addAttribute("orders", orders);
        return "orders";
    }
}
