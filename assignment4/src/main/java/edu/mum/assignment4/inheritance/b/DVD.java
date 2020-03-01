package edu.mum.assignment4.inheritance.b;

import javax.persistence.Entity;

@Entity
public class DVD extends Product1 {


    private String genre;

    public DVD(){

    }
    public DVD(String name, String description) {
        super(name, description);

    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
