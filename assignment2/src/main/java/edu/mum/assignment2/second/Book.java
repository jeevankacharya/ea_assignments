package edu.mum.assignment2.second;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String ISBN;
    private String author;
    private double price;
    private java.util.Date publish_date;


    public Book() {
    }

    public Book(Long id, String title, String isbn, String author, double price, Date publish_date) {
        this.id = id;
        this.title = title;
        ISBN = isbn;
        this.author = author;
        this.price = price;
        this.publish_date = publish_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(Date publish_date) {
        this.publish_date = publish_date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book : [ title : " +title+", ISBN : "+ISBN+", Author : "+author+", Price : "+price+", Published Date : "+publish_date ;
    }
}
