package com.customerservice.controller;

import com.customerservice.classes.MyOrders;
import com.customerservice.model.Customer;
import com.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerservice;

    @PostMapping("/")
    public Customer saveCustomer(@RequestBody Customer customer){
        return this.customerservice.saveCustomer(customer);
    }

    @GetMapping("/{id}")
    public MyOrders myOrders(@PathVariable("id") Long custId){
        return this.customerservice.getMyOrders(custId);
    }
}
