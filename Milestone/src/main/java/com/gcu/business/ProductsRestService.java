package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.model.ProductList;
import com.gcu.model.ProductModel;

@RestController
@RequestMapping("/service")
public class ProductsRestService {

    @Autowired
    private ProductsBusinessService service;

    @GetMapping(path="/getjson", produces={MediaType.APPLICATION_JSON_VALUE})
    public List<ProductModel> getOrdersAsJson() {
        return service.getProducts();
    }

    @GetMapping(path="/getxml", produces={MediaType.APPLICATION_XML_VALUE})
    public ProductList getOrdersAsXml() {
        ProductList list = new ProductList();
        list.setProducts(service.getProducts());
        return list;
    }

    @PostMapping(path="/add")
    public ProductModel addProduct(@RequestBody ProductModel product) {
        System.out.printf("id:%d name:%s price:$%f%n", product.getId(), product.getName(), product.getPrice());
        return product;
    }
}
