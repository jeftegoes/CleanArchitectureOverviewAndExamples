package com.example.core.interfaces;

import com.example.core.entities.Customer;

import java.util.List;

public interface FindCustomerUseCase {
    Customer find(int customerId);

    List<Customer> findAll();
}
