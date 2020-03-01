package edu.mum.assignment4.inheritance.a;

import javax.persistence.*;

@Entity
@Table(name = "orderline_a")
public class OrderLine {

    @Id
    @GeneratedValue
    private int id;

    private double quantity=0.0;

    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "product_id")
    private Product product;

    public  OrderLine(){

    }

    public OrderLine(double quantity){
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
