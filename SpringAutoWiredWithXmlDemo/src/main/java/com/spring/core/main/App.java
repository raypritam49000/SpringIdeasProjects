package com.spring.core.main;

import com.spring.core.entities.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springconfig.xml");
        Employee employee = (Employee) applicationContext.getBean("employee");
        System.out.println(employee);
        System.out.println(employee.getAddress());
    }
}
