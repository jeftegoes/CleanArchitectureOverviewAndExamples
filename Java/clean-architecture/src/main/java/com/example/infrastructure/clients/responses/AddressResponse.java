package com.example.infrastructure.clients.responses;

import lombok.Data;

@Data
public class AddressResponse {
    private String logradouro;
    private String localidade;
    private String estado;
}