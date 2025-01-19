package com.example.web.controllers.responses;

import lombok.Data;

@Data
public class CustomerResponse {
    private int id;
    private String name;
    private AddressResponse address;
}
