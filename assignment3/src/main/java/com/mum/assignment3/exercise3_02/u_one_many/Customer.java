package com.mum.assignment3.exercise3_02.u_one_many;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    public Customer(String name) {
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

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Id
    @GeneratedValue
    private  int id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable
    private List<Reservation> reservations = new ArrayList<>();

    public  Customer(){

    }
}
