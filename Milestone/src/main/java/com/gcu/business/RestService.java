package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @PostMapping(path="/addproduct")
    public ProductModel addProduct(@RequestBody ProductModel product) {
        boolean isSuccess = productsService.addProduct(new ProductEntity(product.getName(), product.getPrice()));
        if(isSuccess) {
            return product;
        }
        return null;
    }

    @PostMapping(path="/updateproduct")
    public ProductModel updateProduct(@RequestBody ProductModel product) {
        System.out.printf("id:%d name:%s price:$%f%n", product.getId(), product.getName(), product.getPrice());
        if(productsService.exists(product.getId())) {
            boolean isSuccess = productsService.addProduct(new ProductEntity(product.getId(), product.getName(), product.getPrice()));
            if(isSuccess) {
                return product;
            }
        }
        return null;
    }

    @GetMapping(path="/deleteproduct/{id}")
    public void deleteProduct(@PathVariable long id) {
        if(productsService.exists(id)) {
            productsService.deleteProduct(id);
        }
    }

    @PostMapping(path="/addorder")
    public OrderModel addOrder(@RequestBody OrderModel order) {
        System.out.printf("id:%d name:%s price:$%f%n", order.getId(), order.getProductName(), order.getPrice());
        boolean isSuccess = ordersService.addOrder(new OrderEntity(order.getOrderNo(), order.getProductName(), order.getPrice(), order.getQuantity()));
        if(isSuccess) {
            return order;
        }
        return null;
    }

        @PostMapping(path="/updateorder")
        public OrderModel updateOrder(@RequestBody OrderModel order) {
            System.out.printf("id:%d name:%s price:$%f%n", order.getId(), order.getProductName(), order.getPrice());
            if(ordersService.exists(order.getId())) {
                boolean isSuccess = ordersService.addOrder(new OrderEntity(order.getId(), order.getOrderNo(), order.getProductName(), order.getPrice(), order.getQuantity()));
                if(isSuccess) {
                    return order;
                }
            }
            return null;
        }

        @GetMapping(path="deleteorder/{id}")
        public void deleteOrder(@PathVariable long id) {
            if(ordersService.exists(id)) {
                ordersService.deleteOrder(id);
            }
        }

    // @PostMapping(path="/addCustomer")
    // public void addCustomer(@RequestBody RegisterModel customer) {
    //      customersService.addCustomer(new CustomerEntity(customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getPassword(), null, null))
    // }
}
