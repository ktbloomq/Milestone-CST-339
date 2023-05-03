package com.gcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gcu.business.ProductsBusinessService;
import com.gcu.data.entity.ProductEntity;
import com.gcu.model.ProductModel;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/products")
public class Product_Controller {

    @Autowired 
    private ProductsBusinessService service;

    
    /** 
     * @param model
     * @return String
     */
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
        model.addAttribute("title", "Add Product");
        return "new_products";
    }
    
    @PostMapping("/createItem")
    public String createItem(@Valid ProductModel productModel, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("title", "Product Creation Form");
            return "new_products";
        }
        System.out.printf("id:%d name:%s price:$%f%n", productModel.getId(), productModel.getName(), productModel.getPrice());
        service.addProduct(new ProductEntity(productModel.getName(), productModel.getPrice()));
        
        model.addAttribute("title", "Products");
        return "redirect:/products";
    }

    @GetMapping("/update")
    public String updateProduct(Model model) {
        model.addAttribute("productModel", new ProductModel());
        model.addAttribute("title", "Update Product");
        return "update_product";
    }
    
    @PostMapping("/updateProduct")
    public String updateProduct(@Valid ProductModel productModel, boolean delete, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors() && !service.exists(productModel.getId())) {
            model.addAttribute("title", "Update Product");
            return "new_products";
        }
        
        if(delete) {
            System.out.println("deleting " + productModel.getId());
            service.deleteProduct(productModel.getId());
        } else {
            System.out.printf("id:%d name:%s price:$%f%n", productModel.getId(), productModel.getName(), productModel.getPrice());
            service.addProduct(new ProductEntity(productModel.getId(), productModel.getName(), productModel.getPrice()));
        }

        
        model.addAttribute("title", "Products");
        return "redirect:/products";
    }

    @GetMapping("/delete")
    public String deleteProduct(Model model) {
        // model.addAttribute("productModel", new ProductModel());
        model.addAttribute("title", "Update Product");
        return "delete_product";
    }
    
    @PostMapping("/deleteProduct")
    public String deleteProduct(@RequestParam long id) {
      
        System.out.println("deleting ID: " + id);
        if(service.exists(id)) {
            service.deleteProduct(id);
            return "redirect:/products";
        } else {
            return "delete_product";
        }
    }
}