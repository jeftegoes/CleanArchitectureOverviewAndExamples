package com.example.infrastructure.clients;

import com.example.core.entities.Address;
import com.example.core.interfaces.FindAddressByZipCode;
import com.example.infrastructure.clients.mappers.AddressResponseMapper;
import com.example.infrastructure.clients.responses.AddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeImpl implements FindAddressByZipCode {
    private final FindAddressByZipCodeClient findAddressByZipCodeClient;
    private final AddressResponseMapper addressResponseMapper;

    @Autowired
    public FindAddressByZipCodeImpl(FindAddressByZipCodeClient findAddressByZipCodeClient, AddressResponseMapper addressResponseMapper) {
        this.findAddressByZipCodeClient = findAddressByZipCodeClient;
        this.addressResponseMapper = addressResponseMapper;
    }

    @Override
    public Address find(String zipCode) {
        AddressResponse addressResponse = this.findAddressByZipCodeClient.getCep(zipCode);
        Address address = addressResponseMapper.toAddress(addressResponse);
        return address;
    }
}
