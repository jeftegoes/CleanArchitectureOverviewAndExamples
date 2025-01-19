package com.example.web.controllers;

import com.example.core.entities.Customer;
import com.example.core.interfaces.DeleteCustomerUseCase;
import com.example.core.interfaces.FindCustomerUseCase;
import com.example.core.interfaces.InsertCustomerUseCase;
import com.example.core.interfaces.UpdateCustomerUseCase;
import com.example.web.controllers.mappers.CustomerMapper;
import com.example.web.controllers.requests.CustomerRequest;
import com.example.web.controllers.responses.CustomerResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final InsertCustomerUseCase insertCustomerUseCase;
    private final FindCustomerUseCase findCustomerUseCase;
    private final DeleteCustomerUseCase deleteCustomerUseCase;
    private final UpdateCustomerUseCase updateCustomerUseCase;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerController(
            InsertCustomerUseCase insertCustomerInputPort,
            FindCustomerUseCase findCustomerUseCase,
            DeleteCustomerUseCase deleteCustomerUseCase,
            UpdateCustomerUseCase updateCustomerUseCase,
            CustomerMapper customerMapper
    ) {
        this.insertCustomerUseCase = insertCustomerInputPort;
        this.findCustomerUseCase = findCustomerUseCase;
        this.deleteCustomerUseCase = deleteCustomerUseCase;
        this.updateCustomerUseCase = updateCustomerUseCase;
        this.customerMapper = customerMapper;
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
        Customer customer = this.customerMapper.toCustomer(customerRequest);

        this.insertCustomerUseCase.insert(customer, customerRequest.getZipCode());

        return ResponseEntity.ok().build();
    }


    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponse> find(@PathVariable int customerId) {
        Customer customer = this.findCustomerUseCase.find(customerId);

        CustomerResponse customerResponse = this.customerMapper.toCustomerResponse(customer);

        return ResponseEntity.ok(customerResponse);
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> findAll() {
        List<Customer> customers = this.findCustomerUseCase.findAll();

        List<CustomerResponse> customersResponse = this.customerMapper.toCustomersResponse(customers);

        return ResponseEntity.ok(customersResponse);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> delete(@PathVariable int customerId) {
        this.deleteCustomerUseCase.delete(customerId);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id, @RequestBody CustomerRequest customerRequest) {
        Customer customer = this.customerMapper.toCustomer(customerRequest);
        customer.setId(id);

        this.updateCustomerUseCase.update(customer, customerRequest.getZipCode());

        return ResponseEntity.ok().build();
    }
}
