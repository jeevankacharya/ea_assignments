package edu.mum.assignment4.collection.b;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Flight {

    @Id
    @GeneratedValue
    private  int id;

    private String flightNumber;
    private String pfrom;
    private String pto;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Flight(){

    }


    Flight(String flightNumber, String from, String to, Date date) {
        this.flightNumber = flightNumber;
        this.pfrom = from;
        this.pto = to;
        this.date = date;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }



    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPfrom() {
        return pfrom;
    }

    public void setPfrom(String pfrom) {
        this.pfrom = pfrom;
    }

    public String getPto() {
        return pto;
    }

    public void setPto(String pto) {
        this.pto = pto;
    }
}
