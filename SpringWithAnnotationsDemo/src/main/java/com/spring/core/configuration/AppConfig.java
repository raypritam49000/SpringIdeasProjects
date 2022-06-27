package com.spring.core.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public StudentManagerImpl getStudentManagerImpl(){
        return new StudentManagerImpl();
    }
}
