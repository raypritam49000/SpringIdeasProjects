package main;

import configuration.AppConfig;
import model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Student student = applicationContext.getBean(Student.class);
        System.out.println(student);
    }
}
