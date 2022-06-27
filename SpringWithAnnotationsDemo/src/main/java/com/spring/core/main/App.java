package com.spring.core.main;

import com.spring.core.configuration.AppConfig;
import com.spring.core.configuration.StudentManager;
import com.spring.core.configuration.StudentManagerImpl;
import com.spring.core.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        StudentManager studentManager = ctx.getBean(StudentManagerImpl.class);
        Student student = studentManager.getStudent();
        System.out.println(student);
        System.out.println(student.getId()+" "+student.getName()+" "+student.getAge()+" "+student.getSalary());
    }
}
