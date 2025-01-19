package com.example.infrastructure.repositories;

import com.example.core.entities.Customer;
import com.example.core.interfaces.UpdateCustomerRepository;
import com.example.infrastructure.repositories.entities.CustomerEntity;
import com.example.infrastructure.repositories.mappers.CustomerEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerRepositoryImpl implements UpdateCustomerRepository {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    public UpdateCustomerRepositoryImpl(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public void update(Customer customer) {
        CustomerEntity customerEntity = this.customerEntityMapper.toCustomerEntity(customer);

        this.customerRepository.save(customerEntity);
    }
}
