package edu.mum.assignment4.inheritance.a;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "_Order")
public class Order {

    @Id
    @GeneratedValue
    private int orderId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne()
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "order_orderlineId")
    private List<OrderLine> orderLines = new ArrayList<>();

    public Order() {
    }

    public Order(Date date) {
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;

    }
}
