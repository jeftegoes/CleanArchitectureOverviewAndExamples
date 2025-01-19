package com.example.core.interfaces;

import com.example.core.entities.Customer;

public interface InsertCustomerUseCase {
    public void insert(Customer customer, String zipCode);
}
