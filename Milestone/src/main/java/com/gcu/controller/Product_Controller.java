package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.OrderModel;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/products")
public class Product_Controller {

    @GetMapping("/")
    public String display(Model model) {
        model.addAttribute("title", "Products");
        model.addAttribute("orderModel", new OrderModel());
        return "products";
    }
    
    @PostMapping("/createItem")
    public String createItem(OrderModel orderModel, Model model) {

        System.out.printf("");
       
        
        model.addAttribute("title", "Products");
        return "products";
    }
}