package configuration;

import model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Student getStudent(){
     Student st = new Student(123,"Pritam Ray","Ropar");
     return st;
    }
}
