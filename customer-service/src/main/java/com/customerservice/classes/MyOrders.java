package com.customerservice.classes;

import com.customerservice.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyOrders {
    private Customer customer;
    private Product product;
}
