package com.mum.assignment3.exercise3_02.b_one_many;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL/*mappedBy = "department"*/)
    @JoinColumn
    private  List<Employee> employees = new ArrayList<>();

    public Department() {
    }

    public Department(String name) {
        this.name = name;
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

    public List<Employee> getEmployeeList() {
        return employees;
    }

    public void setEmployeeList(List<Employee> employee) {
        this.employees= employee;
        employees.forEach(employee1 -> employee1.setDepartment(this));

    }

}
