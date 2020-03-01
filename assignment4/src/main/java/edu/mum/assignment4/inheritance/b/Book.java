package edu.mum.assignment4.inheritance.b;

import javax.persistence.Entity;

@Entity
public class Book extends Product1 {

    private String title;

    public  Book(){

    }
    public Book(String name, String description) {
        super(name, description);

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
