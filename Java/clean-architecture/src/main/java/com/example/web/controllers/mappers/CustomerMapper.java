package com.example.web.controllers.mappers;


import com.example.core.entities.Customer;
import com.example.web.controllers.requests.CustomerRequest;
import com.example.web.controllers.responses.CustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    @Mapping(target = "id", ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);

    CustomerResponse toCustomerResponse(Customer customer);

    List<CustomerResponse> toCustomersResponse(List<Customer> customer);
}
