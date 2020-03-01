package edu.mum.assignment4.inheritance.b;

import javax.persistence.Entity;

@Entity
public class CD extends Product1 {

    private String artist;

    public CD() {

    }

    public CD(String name, String description) {
        super(name, description);

    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
