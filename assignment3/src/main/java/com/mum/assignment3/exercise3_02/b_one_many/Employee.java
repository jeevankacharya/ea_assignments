package com.mum.assignment3.exercise3_02.b_one_many;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private int employeeNumber;
    private String name;

    @ManyToOne()
    @JoinColumn(name = "department_id")
    private Department department;

    public Employee() {
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee(String name) {
        this.name = name;
    }


}
