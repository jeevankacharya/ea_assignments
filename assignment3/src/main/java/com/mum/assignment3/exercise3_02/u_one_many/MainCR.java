package com.mum.assignment3.exercise3_02.u_one_many;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainCR {

    private static final SessionFactory sessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }


    public static void main(String[] args) {
        // Hibernate placeholders
        Session session = null;
        Transaction tx = null;

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();


            Customer customer = new Customer("Jeevan");
            List<Reservation> reservations = new ArrayList<>();
            reservations.add(new Reservation(new Date()));
            reservations.add(new Reservation(new Date()));
            reservations.add(new Reservation(new Date()));
            customer.setReservations(reservations);
            session.persist(customer);


            Customer customer1 = new Customer("Sameer");
            List<Reservation> reservations1 = new ArrayList<>();
            reservations1.add(new Reservation(new Date()));
            reservations1.add(new Reservation(new Date()));
            reservations1.add(new Reservation(new Date()));
            customer1.setReservations(reservations1);
            session.persist(customer1);


            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                System.err.println("Rolling back: " + e.getMessage());
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }


    }
}
