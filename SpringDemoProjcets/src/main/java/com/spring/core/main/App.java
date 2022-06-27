package com.spring.core.main;

import com.spring.core.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springconfig.xml");
        Student student = (Student) applicationContext.getBean("student");
        System.out.println(student);
    }
}
