package main;

import configuration.StudentConfig;
import configuration.StudentManagerImpl;
import model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(StudentConfig.class);
        StudentManagerImpl studentManagerImpl = applicationContext.getBean(StudentManagerImpl.class);
        Student student = studentManagerImpl.getStudent();
        System.out.println(student);
    }
}
