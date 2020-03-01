package edu.mum.assignment4.inheritance.b;


import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "product_inhertance")
public class Product1 {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private  String description;

    public Product1(){}

    public Product1(String name, String description){
        this.name= name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
