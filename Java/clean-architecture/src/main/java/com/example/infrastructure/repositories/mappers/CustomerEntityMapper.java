package com.example.infrastructure.repositories.mappers;

import com.example.core.entities.Customer;
import com.example.infrastructure.repositories.entities.CustomerEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {
    Customer toCustomer(CustomerEntity customerEntity);

    List<Customer> toCustomers(List<CustomerEntity> customerEntity);

    CustomerEntity toCustomerEntity(Customer customer);
}
