package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.OrdersDataSevice;
import com.gcu.data.entity.OrderEntity;
import com.gcu.model.OrderModel;

public class OrdersBusinessService {

    @Autowired
    private OrdersDataSevice service;

    public void test() {
        System.out.println("Hello from the OrdersBusinessService");
    }

    public List<OrderModel> getOrders() {
        // service.create(new OrderEntity("example", "example", 70.0f, 10));
        List<OrderEntity> ordersEntity = service.findAll();
        List<OrderModel> ordersDomain = new ArrayList<OrderModel>();
        for (OrderEntity entity : ordersEntity) {
            ordersDomain.add(new OrderModel(entity.getId(), 
                                            entity.getOrderNo(), 
                                            entity.getProductName(), 
                                            entity.getPrice(), 
                                            entity.getQuantity()));
        }
        return ordersDomain;
    }

    public boolean addOrder(OrderEntity order) {
        return service.create(order);
    }

    public void init() {
        System.out.println("Initializing OrdersBusinessService :)");
    }

    public void destroy() {
        System.out.println("Destroying OrdersBusinessService :(");
    }

    public boolean exists(long id) {
        return service.existsById(id);
    }

    public void deleteOrder(long id) {
        service.deleteById(id);
    }
    
}
