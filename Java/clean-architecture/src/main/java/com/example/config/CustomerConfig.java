package com.example.config;

import com.example.core.interfaces.*;
import com.example.usecases.DeleteCustomerUseCaseImpl;
import com.example.usecases.FindCustomerUseCaseImpl;
import com.example.usecases.InsertCustomerUseCaseImpl;
import com.example.usecases.UpdateCustomerUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {
    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            InsertCustomerRepository insertCustomerRepository,
            FindAddressByZipCode FindAddressByZipCode
    ) {
        return new InsertCustomerUseCaseImpl(insertCustomerRepository, FindAddressByZipCode);
    }

    @Bean
    public FindCustomerUseCase findCustomerUseCase(
            FindCustomerRepository findCustomerRepository
    ) {
        return new FindCustomerUseCaseImpl(findCustomerRepository);
    }

    @Bean
    public DeleteCustomerUseCase deleteCustomerUseCase(
            DeleteCustomerRepository deleteCustomerRepository
    ) {
        return new DeleteCustomerUseCaseImpl(deleteCustomerRepository);
    }

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(
            FindAddressByZipCode FindAddressByZipCode,
            UpdateCustomerRepository updateCustomerRepository
    ) {
        return new UpdateCustomerUseCaseImpl(FindAddressByZipCode, updateCustomerRepository);
    }
}
