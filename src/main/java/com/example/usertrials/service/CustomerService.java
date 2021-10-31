package com.example.usertrials.service;

import com.example.usertrials.dto.CustomerDto;
import com.example.usertrials.dto.CustomerDtoConverter;
import com.example.usertrials.exceptions.UserNotFoundException;
import com.example.usertrials.model.Customer;
import com.example.usertrials.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    private CustomerDto convert(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setAge(customer.getAge());
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        return customerDto;
    }

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer addCustomer(@RequestBody Customer customer) {
        customer.setCreateBy("Admin");
        customer.setCreateAt(new Date());
        return this.customerRepository.save(customer);
    }

    public List<Customer> addCustomers(@RequestBody List<Customer> customers) {
        return this.customerRepository.saveAll(customers);
    }

    public List<CustomerDto> getAll() {
        return customerRepository.findAll().stream().map(this::convert).collect(Collectors.toList());
    }
    //Account ve Transiction ile birlikte getirmek için;
    /*public List<Customer> getAll() {
        return this.customerRepository.findAll();
    }*/

    public Customer getCustomerById(int id) {
        return this.customerRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User couldn't be found by following id" + id));
    }

    public List<Customer> getCustomerByName(String name) {
        return this.customerRepository.findByName(name);
    }

    public Customer updateCustomer(Customer customer) {
        Customer existingCustomer = this.customerRepository.findById(customer.getId())
                .orElseThrow(() -> new UserNotFoundException("User couldn't be found by following id"));
        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setAge(customer.getAge());
        return this.customerRepository.save(existingCustomer);
    }

    public String deleteCustomer(int id) {
        this.customerRepository.deleteById(id);
        return "Customer deleted : " + id;
    }

    public List<Customer> getCustomerByNameAndAge(String name, int age) {
        return this.customerRepository.findByNameAndAge(name, age);
    }
}
