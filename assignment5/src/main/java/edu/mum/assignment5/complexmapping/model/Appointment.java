package edu.mum.assignment5.complexmapping.model;

import javax.persistence.*;

@Entity
public class Appointment {
    @Id
    @GeneratedValue
    private int id;
    private String appdate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PATIENT")
    private Patient patient;

    @Embedded
    private Payment payment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DOCTOR")
    private Doctor doctor;

    public Appointment() {
    }

    public Appointment(String appdate) {
        this.appdate = appdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppdate() {
        return appdate;
    }

    public void setAppdate(String appdate) {
        this.appdate = appdate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Appointment [ App Date :"+ appdate+"] "+"\n"
                +"Patient [ Name "+ patient.getName()+", Address "+ patient.getCity()+"-"+patient.getStreet()+"-"+patient.getZip()+" ] "+"\n"
                +"Payment [ Date " +payment.getPaydate() +", Amount "+payment.getAmount() +"] "+"\n"
                +"Doctor [ Name "+doctor.getFirstname()+" " +doctor.getLastname()+", Type"+doctor.getDoctortype()+"]";
    }
}
