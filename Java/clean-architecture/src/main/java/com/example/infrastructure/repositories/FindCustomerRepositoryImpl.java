package com.example.infrastructure.repositories;

import com.example.core.entities.Customer;
import com.example.core.interfaces.FindCustomerRepository;
import com.example.infrastructure.repositories.entities.CustomerEntity;
import com.example.infrastructure.repositories.mappers.CustomerEntityMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FindCustomerRepositoryImpl implements FindCustomerRepository {
    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    public FindCustomerRepositoryImpl(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public Optional<Customer> find(int customerId) {
        Optional<CustomerEntity> customerEntity = this.customerRepository.findById(customerId);

        Optional<Customer> customer = customerEntity.map(entity -> customerEntityMapper.toCustomer(entity));

        return customer;
    }

    @Override
    public List<Customer> findAll() {
        List<CustomerEntity> customerEntity = this.customerRepository.findAll();

        List<Customer> customers = customerEntityMapper.toCustomers(customerEntity);

        return customers;
    }
}
