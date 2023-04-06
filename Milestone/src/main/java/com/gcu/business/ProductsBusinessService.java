package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.ProductsDataSevice;
import com.gcu.data.entity.ProductEntity;
import com.gcu.model.ProductModel;

public class ProductsBusinessService {

    @Autowired
    private ProductsDataSevice service;

    public void test() {
        System.out.println("Hello from the OrdersBusinessService");
    }

    public List<ProductModel> getProducts() {
        // service.create(new ProductEntity("example", 70.1f));
        List<ProductEntity> productsEntity = service.findAll();
        List<ProductModel> productsDomain = new ArrayList<ProductModel>();
        for (ProductEntity entity : productsEntity) {
            productsDomain.add(new ProductModel(entity.getId(),
                                                entity.getName(),
                                                entity.getPrice()));
        }
        return productsDomain;
    }

    public boolean addProduct(ProductEntity product) {
        return service.create(product);
    }

    public void init() {
        System.out.println("Initializing ProductsBusinessService :)");
    }

    public void destroy() {
        System.out.println("Destroying ProductsBusinessService :(");
    }
    
  
    
    
}
