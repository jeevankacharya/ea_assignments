package edu.mum.assignment4.collection.a;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private int id;

    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
//    @JoinColumn
    private Set<Laptop> laptops = new HashSet<>();

   public Employee() {

    }

   public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }



    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(Set<Laptop> laptops) {
        this.laptops = laptops;
        this.laptops.forEach(laptop -> laptop.setEmployee(this));
    }
}
