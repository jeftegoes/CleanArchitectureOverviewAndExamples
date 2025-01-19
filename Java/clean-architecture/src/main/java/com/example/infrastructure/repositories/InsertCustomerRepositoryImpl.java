package com.example.infrastructure.repositories;

import com.example.core.entities.Customer;
import com.example.core.interfaces.InsertCustomerRepository;
import com.example.infrastructure.repositories.entities.CustomerEntity;
import com.example.infrastructure.repositories.mappers.CustomerEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerRepositoryImpl implements InsertCustomerRepository {
    private final CustomerEntityMapper customerEntityMapper;
    private final CustomerRepository customerRepository;

    @Autowired
    public InsertCustomerRepositoryImpl(CustomerEntityMapper customerEntityMapper, CustomerRepository customerRepository) {
        this.customerEntityMapper = customerEntityMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public void insert(Customer customer) {
        CustomerEntity customerEntity = this.customerEntityMapper.toCustomerEntity(customer);

        this.customerRepository.save(customerEntity);
    }
}
