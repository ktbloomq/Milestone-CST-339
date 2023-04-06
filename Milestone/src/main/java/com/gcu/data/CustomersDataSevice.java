package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.CustomerEntity;
import com.gcu.data.repository.CustomersRepository;

@Service
public class CustomersDataSevice implements DataAccessInterface<CustomerEntity> {

    @Autowired
    private CustomersRepository customersRepository;

    public CustomersDataSevice(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    @Override
    public List<CustomerEntity> findAll() {
        List<CustomerEntity> customers = new ArrayList<CustomerEntity>();
        try {
            Iterable<CustomerEntity> customersIterable = customersRepository.findAll();
            customersIterable.forEach(customers::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public CustomerEntity FindById(int id) {
        return null;
    }

    @Override
    public boolean create(CustomerEntity customer) {
        try {
            this.customersRepository.save(customer);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(CustomerEntity t) {
        return true;
    }

    @Override
    public boolean delete(CustomerEntity t) {
        return true;
    }
    
}
