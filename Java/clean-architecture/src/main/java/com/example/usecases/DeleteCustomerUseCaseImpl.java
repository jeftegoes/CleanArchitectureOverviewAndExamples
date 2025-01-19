package com.example.usecases;

import com.example.core.interfaces.DeleteCustomerRepository;
import com.example.core.interfaces.DeleteCustomerUseCase;

public class DeleteCustomerUseCaseImpl implements DeleteCustomerUseCase {

    private final DeleteCustomerRepository deleteCustomerRepository;

    public DeleteCustomerUseCaseImpl(DeleteCustomerRepository deleteCustomerRepository) {
        this.deleteCustomerRepository = deleteCustomerRepository;
    }

    @Override
    public void delete(int customerId) {
        this.deleteCustomerRepository.delete(customerId);
    }
}
