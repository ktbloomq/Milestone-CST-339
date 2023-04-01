package com.gcu.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProductModel {
    @NotNull(message = "Enter product id")
    private int Id;

    @NotNull(message = "Enter product name")
    @Size(max = 50, message = "product name is too long")
    private String Name;

    @NotNull(message = "Enter product price")
    private float Price;

    public ProductModel() {
        
    }

    public ProductModel(int id, String name, float price) {
        this.Id = id;
        this.Name = name;
        this.Price = price;
    }

    
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        this.Id = id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        this.Name = name;
    }
    public float getPrice() {
        return Price;
    }
    public void setPrice(float price) {
        this.Price = price;
    }    
}
