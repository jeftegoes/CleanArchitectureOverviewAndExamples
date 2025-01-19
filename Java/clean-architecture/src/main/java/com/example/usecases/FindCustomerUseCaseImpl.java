package com.example.usecases;

import com.example.core.entities.Customer;
import com.example.core.interfaces.FindCustomerRepository;
import com.example.core.interfaces.FindCustomerUseCase;

import java.util.List;

public class FindCustomerUseCaseImpl implements FindCustomerUseCase {
    private final FindCustomerRepository findCustomerRepository;

    public FindCustomerUseCaseImpl(FindCustomerRepository findCustomerRepository) {
        this.findCustomerRepository = findCustomerRepository;
    }

    @Override
    public Customer find(int customerId) {
        return this.findCustomerRepository.find(customerId).orElseThrow(() -> new RuntimeException("Customer not found!"));
    }

    @Override
    public List<Customer> findAll() {
        return this.findCustomerRepository.findAll();
    }
}
