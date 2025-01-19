package com.example.core.interfaces;

import com.example.core.entities.Customer;

public interface UpdateCustomerUseCase {
    void update(Customer customer, String zipCode);
}
