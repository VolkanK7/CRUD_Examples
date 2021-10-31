package com.example.usertrials.controller;

import com.example.usertrials.dto.CustomerDto;
import com.example.usertrials.model.Customer;
import com.example.usertrials.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/addcustomer")
    public Customer addCustomer(@RequestBody Customer customer){
        return this.customerService.addCustomer(customer);
    }

    @PostMapping("/addcustomers")
    public List<Customer> addCustomers(@RequestBody List<Customer> customers){
        return this.customerService.addCustomers(customers);
    }

    @GetMapping("/getall")
    public List<CustomerDto> getAll(){
        return this.customerService.getAll();
    }

  /*  @GetMapping("/getall")
    public List<Customer> getAll(){
        return this.customerService.getAll();
    }*/

    @GetMapping("/getcustomerById/{id}")
    public Customer getCustomerById(@PathVariable int id){
        return this.customerService.getCustomerById(id);
    }

    @GetMapping("/getcustomerByName/{name}")
    public List<Customer> getCustomerByName(@PathVariable String name){
        return this.customerService.getCustomerByName(name);
    }

    @PutMapping("/updatecustomer")
    public Customer updateCustomer(@RequestBody Customer customer){
        return this.customerService.updateCustomer(customer);
    }

    @DeleteMapping("/deletecustomer/{id}")
    public String deleteCustomer(@PathVariable int id){
        return this.customerService.deleteCustomer(id);
    }

    @GetMapping("/getByNameAndAge/{name}/{age}")
    public List<Customer> getCustomerByNameAndAge(@PathVariable String name, int age){
        return this.customerService.getCustomerByNameAndAge(name,age);
    }
}
