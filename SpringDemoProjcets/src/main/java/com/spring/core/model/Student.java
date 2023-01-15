package com.spring.core.model;

import java.util.List;

public class Student {
    private int id;
    private String name;
    private double salary;
    private List<String> phone;

    public Student(int id, String name, double salary,List<String>phone) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.phone = phone;
    }

    public Student() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        System.out.println("Set Id....");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("Set Name....");
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        System.out.println("Set Salary....");
        this.salary = salary;
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
                ", phone=" + phone +
                '}';
    }
}
