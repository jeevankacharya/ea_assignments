package edu.mum.assignment4.inheritance.b;

import javax.persistence.*;

@Entity
@Table(name = "orderline_inhertance")
public class OrderLine1 {

    @Id
    @GeneratedValue
    private int id;

    private double quantity=0.0;

    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "product_id")
    private Product1 product;

    public OrderLine1(){

    }

    public OrderLine1(double quantity){
        this.quantity = quantity;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product1 getProduct() {
        return product;
    }

    public void setProduct(Product1 product) {
        this.product = product;
    }
}
