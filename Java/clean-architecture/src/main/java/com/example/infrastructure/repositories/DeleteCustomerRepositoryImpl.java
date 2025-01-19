package com.example.infrastructure.repositories;

import com.example.core.interfaces.DeleteCustomerRepository;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerRepositoryImpl implements DeleteCustomerRepository {
    private final CustomerRepository customerRepository;

    public DeleteCustomerRepositoryImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void delete(int customerId) {
        this.customerRepository.deleteById(customerId);
    }
}
