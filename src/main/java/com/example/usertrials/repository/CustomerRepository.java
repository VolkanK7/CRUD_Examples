package com.example.usertrials.repository;

import com.example.usertrials.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    List<Customer> findByName(String name);

    List<Customer> findByNameAndAge(String name, int age);
}
