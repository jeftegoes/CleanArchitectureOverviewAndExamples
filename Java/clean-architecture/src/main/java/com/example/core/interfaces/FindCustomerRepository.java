package com.example.core.interfaces;

import com.example.core.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface FindCustomerRepository {
    Optional<Customer> find(int customerId);

    List<Customer> findAll();
}
