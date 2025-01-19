package com.example.infrastructure.clients.mappers;

import com.example.core.entities.Address;
import com.example.infrastructure.clients.responses.AddressResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {
    @Mapping(source = "logradouro", target = "street")
    @Mapping(source = "localidade", target = "city")
    @Mapping(source = "estado", target = "state")
    Address toAddress(AddressResponse addressResponse);
}
