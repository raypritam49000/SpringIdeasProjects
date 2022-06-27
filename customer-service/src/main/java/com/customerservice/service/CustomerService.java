package com.customerservice.service;

import com.customerservice.classes.MyOrders;
import com.customerservice.classes.Product;
import com.customerservice.model.Customer;
import com.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Customer saveCustomer(Customer customer){
      return this.customerRepository.save(customer);
    }

    public MyOrders getMyOrders(Long custId){
        Customer customers = this.customerRepository.findById(custId).get();
        Long pId = customers.getPId();
        Product product = this.restTemplate.getForObject("http://PRODUCT-SERVICE/product/"+pId, Product.class);
        MyOrders myOrders = new MyOrders();
        myOrders.setCustomer(customers);
        myOrders.setProduct(product);
        return myOrders;

    }
}
