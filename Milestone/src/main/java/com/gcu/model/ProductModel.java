package com.gcu.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProductModel {
    @NotNull(message = "Enter product id")
    private long id;

    @NotNull(message = "Enter product name")
    @Size(max = 50, message = "product name is too long")
    private String name;

    @NotNull(message = "Enter product price")
    private float price;

    public ProductModel() {
        
    }

    public ProductModel(long id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }    
}
