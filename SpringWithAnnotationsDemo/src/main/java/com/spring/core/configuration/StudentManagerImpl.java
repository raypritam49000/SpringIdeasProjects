package com.spring.core.configuration;

import com.spring.core.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentManagerImpl implements StudentManager{

    @Override
    public List<String> getPhone() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("8699545683");
        list.add("7696889464");
        return list;
    }

    @Override
    public Student getStudent() {
        Student student = new Student();
        student.setName("Pritam Ray");
        student.setId(123);
        student.setAge(25);
        student.setSalary(450000.00);
        student.setPhone(getPhone());
        return student;
    }
}
