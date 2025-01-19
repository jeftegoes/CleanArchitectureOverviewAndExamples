package com.example.usecases;

import com.example.core.entities.Address;
import com.example.core.entities.Customer;
import com.example.core.interfaces.FindAddressByZipCode;
import com.example.core.interfaces.UpdateCustomerRepository;
import com.example.core.interfaces.UpdateCustomerUseCase;

public class UpdateCustomerUseCaseImpl implements UpdateCustomerUseCase {
    private final FindAddressByZipCode findAddressByZipCode;
    private final UpdateCustomerRepository updateCustomerRepository;

    public UpdateCustomerUseCaseImpl(FindAddressByZipCode findAddressByZipCode, UpdateCustomerRepository updateCustomerRepository) {
        this.findAddressByZipCode = findAddressByZipCode;
        this.updateCustomerRepository = updateCustomerRepository;
    }

    @Override
    public void update(Customer customer, String zipCode) {
        Address address = this.findAddressByZipCode.find(zipCode);

        customer.setAddress(address);

        this.updateCustomerRepository.update(customer);
    }
}
