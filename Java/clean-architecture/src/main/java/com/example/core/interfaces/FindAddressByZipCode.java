package com.example.core.interfaces;

import com.example.core.entities.Address;

public interface FindAddressByZipCode {
    Address find(String zipCode);
}
