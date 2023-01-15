package com.spring.core.entities;

public class Employee {
    private Address address;

    public Employee() {
        super();
    }

    public Employee(Address address) {
        this.address = address;
        System.out.println("inside constructor.....");
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        System.out.println("Setting Value.....");
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "address=" + address +
                '}';
    }
}
