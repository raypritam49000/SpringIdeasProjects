package com.spring.core.main;

import com.spring.core.configs.AppConfig;
import com.spring.core.entities.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {
    public static void main(String[] args) {
        ApplicationContext  applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Employee employee = applicationContext.getBean(Employee.class);
        System.out.println(employee);
    }
}
