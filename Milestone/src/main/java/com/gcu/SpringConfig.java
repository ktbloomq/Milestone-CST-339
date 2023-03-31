package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.gcu.business.OrdersBusinessService;
import com.gcu.business.OrdersBusinessServiceInterface;
import com.gcu.business.ProductsBusinessService;

@Configuration
@EnableWebMvc
public class SpringConfig {
    
    @Bean(name="ordersBusinessService", initMethod ="init", destroyMethod ="destroy")
    public OrdersBusinessServiceInterface getOrdersBusiness() {
        return new OrdersBusinessService();
    }

    @Bean(name="productsBusinessService", initMethod ="init", destroyMethod ="destroy")
    public ProductsBusinessService getProductsBusiness() {
        return new ProductsBusinessService();
    }
}
