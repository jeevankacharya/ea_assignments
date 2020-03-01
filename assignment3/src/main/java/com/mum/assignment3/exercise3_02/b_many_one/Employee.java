package com.mum.assignment3.exercise3_02.b_many_one;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Long employeeNumber;

    private String name;

    @ManyToOne()
    @JoinColumn()
    private Department department;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn()
    private Office office;

    public Employee() {

    }

    public  Employee(String name){
        this.name= name;
    }

    public Long getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Long employeeNumber) {
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

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
}
