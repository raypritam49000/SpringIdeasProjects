package com.spring.core.configuration;

import com.spring.core.model.Student;

import java.util.List;

public interface StudentManager {
    public abstract Student getStudent();
    public abstract List<String> getPhone();
}
