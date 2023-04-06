package com.gcu.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.gcu.data.entity.CustomerEntity;

public interface CustomersRepository extends CrudRepository<CustomerEntity,Long> {
}
