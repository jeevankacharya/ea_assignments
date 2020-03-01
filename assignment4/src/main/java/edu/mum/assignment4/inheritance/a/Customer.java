package edu.mum.assignment4.inheritance.a;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer_a")
public class Customer {

    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
//    @JoinColumn()
    private List<Order> orders = new ArrayList<>();

    public Customer(){

    }

    public Customer(String firstName,String lastName){
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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
        this.orders.forEach(order -> order.setCustomer(this));
    }
}
