package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.data.entity.OrderEntity;
import com.gcu.data.entity.ProductEntity;
import com.gcu.model.OrderModel;
// import com.gcu.model.ProductList;
import com.gcu.model.ProductModel;

@RestController
@RequestMapping("/service")
public class RestService {

    @Autowired
    private ProductsBusinessService productsService;

    @Autowired
    private OrdersBusinessService ordersService;

    @GetMapping(path="/getproducts", produces={MediaType.APPLICATION_JSON_VALUE})
    public List<ProductModel> getProductsAsJson() {
        return productsService.getProducts();
    }

    @GetMapping(path="/getorders", produces={MediaType.APPLICATION_JSON_VALUE})
    public List<OrderModel> getOrdersAsJson() {
        return ordersService.getOrders();
    }

    // @GetMapping(path="/getxml", produces={MediaType.APPLICATION_XML_VALUE})
    // public ProductList getOrdersAsXml() {
    //     ProductList list = new ProductList();
    //     list.setProducts(service.getProducts());
    //     return list;
    // }

    @PostMapping(path="/addProduct")
    public ProductModel addProduct(@RequestBody ProductModel product) {
        System.out.printf("id:%d name:%s price:$%f%n", product.getId(), product.getName(), product.getPrice());
        boolean isSuccess = productsService.addProduct(new ProductEntity(product.getName(), product.getPrice()));
        if(isSuccess) {
            return product;
        }
        return null;
    }

    @PostMapping(path="/addOrder")
    public OrderModel addOrder(@RequestBody OrderModel order) {
        System.out.printf("id:%d name:%s price:$%f%n", order.getId(), order.getProductName(), order.getPrice());
        boolean isSuccess = ordersService.addOrder(new OrderEntity(order.getOrderNo(), order.getProductName(), order.getPrice(), order.getQuantity()));
        if(isSuccess) {
            return order;
        }
        return null;
    }
}
