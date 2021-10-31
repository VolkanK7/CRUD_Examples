package com.example.usertrials.dto;

import com.example.usertrials.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoConverter {
    public CustomerDto convert(Customer customer){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setAge(customer.getAge());
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        return customerDto;
    }
}
