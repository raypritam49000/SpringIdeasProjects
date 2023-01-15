package com.spring.core.configs;

import com.spring.core.entities.Address;
import com.spring.core.entities.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Address getAddress(){
        Address address = new Address();
        address.setCity("Ropar");
        address.setState("Punjab");
        address.setStreet("Asron");
        return address;
    }

    @Bean
    public Employee getEmployee(){
        Employee employee = new Employee();
        return  employee;
    }
}
