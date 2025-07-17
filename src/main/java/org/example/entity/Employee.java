package org.example.entity;

import java.util.Objects;

public class Employee {
    private int id;

    public Integer getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastName() {
        return lastname;
    }

    private String firstname;
    private String lastname;

    public Employee(int id, String name, String lastName) {
        this.id = id;
        this.firstname = name;
        this.lastname = lastName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + firstname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Employee employee)) return false;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
