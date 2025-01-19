package com.example.usecases;

import com.example.core.entities.Address;
import com.example.core.entities.Customer;
import com.example.core.interfaces.FindAddressByZipCode;
import com.example.core.interfaces.InsertCustomerRepository;
import com.example.core.interfaces.InsertCustomerUseCase;

public class InsertCustomerUseCaseImpl implements InsertCustomerUseCase {
    private final InsertCustomerRepository insertCustomerRepository;
    private final FindAddressByZipCode findAddressByZipCode;

    public InsertCustomerUseCaseImpl(
            InsertCustomerRepository insertCustomerRepository,
            FindAddressByZipCode findAddressByZipCode) {
        this.insertCustomerRepository = insertCustomerRepository;
        this.findAddressByZipCode = findAddressByZipCode;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        Address address = this.findAddressByZipCode.find(zipCode);
        customer.setAddress(address);
        this.insertCustomerRepository.insert(customer);
    }
}
