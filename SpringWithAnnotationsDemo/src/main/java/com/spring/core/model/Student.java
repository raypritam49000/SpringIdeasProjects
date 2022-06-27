package com.spring.core.model;

import java.util.List;

public class Student {
    private int id;
    private String name;
    private double salary;
    private int age;
    private List<String> phone;

    public Student(int id, String name, double salary, int age,List<String> phone) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.phone = phone;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getPhone() {
        return phone;
    }

    public void setPhone(List<String> phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", phone=" + phone +
                '}';
    }
}
