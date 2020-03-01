package edu.mum.assignment4.inheritance.b;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "_Order_Inheritance")
public class Order1 {

    @Id
    @GeneratedValue
    private int orderId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne()
    private Customer1 customer;

    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "order_orderlineId")
    private List<OrderLine1> orderLines = new ArrayList<>();

    public Order1() {
    }

    public Order1(Date date) {
        this.date = date;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer1 getCustomer() {
        return customer;
    }

    public void setCustomer(Customer1 customer) {
        this.customer = customer;
    }

    public List<OrderLine1> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine1> orderLines) {
        this.orderLines = orderLines;

    }
}
