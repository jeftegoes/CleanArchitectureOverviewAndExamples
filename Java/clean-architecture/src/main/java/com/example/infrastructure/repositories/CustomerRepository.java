package com.example.infrastructure.repositories;

import com.example.infrastructure.repositories.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
}
