package com.example.infrastructure.clients;

import com.example.core.entities.Address;
import com.example.core.interfaces.FindAddressByZipCode;

import com.example.infrastructure.clients.responses.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "FindAddressByZipCodeClient",
        url = "${zipcode.client.address}")
public interface FindAddressByZipCodeClient {
    @GetMapping("/{zipCode}/json/")
    AddressResponse getCep(@PathVariable String zipCode);
}
