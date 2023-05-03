package com.gcu.data.entity;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("PRODUCTS")
public class ProductEntity {

    @Id
    private long id;
    
    @Column("NAME")
    private String name;

    @Column("PRICE")
    private float price;

    public ProductEntity() {
        
    }

    public ProductEntity(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public ProductEntity(long id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    
    /** 
     * @return long
     */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String productName) {
        this.name = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    
}
