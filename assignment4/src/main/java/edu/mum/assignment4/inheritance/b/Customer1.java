package edu.mum.assignment4.inheritance.b;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer_inhertance")
public class Customer1 {

    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
//    @JoinColumn()
    private List<Order1> order1s = new ArrayList<>();

    public Customer1(){

    }

    public Customer1(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Order1> getOrder1s() {
        return order1s;
    }

    public void setOrder1s(List<Order1> order1s) {
        this.order1s = order1s;
        this.order1s.forEach(order1 -> order1.setCustomer(this));
    }
}
