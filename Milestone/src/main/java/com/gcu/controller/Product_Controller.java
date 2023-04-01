package com.gcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.ProductsBusinessService;
import com.gcu.model.ProductModel;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/products")
public class Product_Controller {

    @Autowired 
    private ProductsBusinessService service;

    @GetMapping("")
    public String productsPage(Model model) {
        List<ProductModel> products = service.getProducts();
        model.addAttribute("title", "Products");
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/newItem")
    public String display(Model model) {
        model.addAttribute("productModel", new ProductModel());
        model.addAttribute("title", "Products");
        return "new_products";
    }
    
    @PostMapping("/createItem")
    public String createItem(@Valid ProductModel productModel, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("title", "Product Creation Form");
            return "new_products";
        }
        System.out.printf("id:%d name:%s price:$%f%n", productModel.getId(), productModel.getName(), productModel.getPrice());
       
        
        model.addAttribute("title", "Products");
        return "redirect:/products";
    }
}