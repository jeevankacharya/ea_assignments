package com.mum.assignment3.exercise3_02.u_one_many;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Reservation {

    public Reservation() {
    }

    public Reservation(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Id
    @GeneratedValue
    private int id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
}
