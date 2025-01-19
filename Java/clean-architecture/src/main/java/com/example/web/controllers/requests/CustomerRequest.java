package com.example.web.controllers.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String zipCode;
}
