package configuration;

import model.Student;
import org.springframework.stereotype.Component;

@Component("student")
public class StudentManagerImpl implements StudentManager{
    @Override
    public Student getStudent() {
        Student st = new Student();
        st.setId(12345);
        st.setName("Pritam Ray");
        st.setCity("Ropar");
        st.setSalary(400000);
        return st;
    }
}
