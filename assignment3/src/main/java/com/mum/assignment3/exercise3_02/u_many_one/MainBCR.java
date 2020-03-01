package com.mum.assignment3.exercise3_02.u_many_one;
//solved
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

public class MainBCR {

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

            Book book = new Book("My First Work", "Jeevan Acharya");
            Customer customer = new Customer("Sameer Maharjan");
            List<Reservation> reservations = new ArrayList<>();
            Reservation reservation = new Reservation(new Date());
            reservation.setBook(book);
            Reservation reservation1 = new Reservation(new Date());
            reservation1.setBook(book);
            reservations.add(reservation);
            reservations.add(reservation1);
            customer.setReservations(reservations);
            session.persist(customer);

            Book book1 = new Book("My Second Work", "Hari Bhusal");
            Customer customer1 = new Customer("Ram KC");
            List<Reservation> reservationList = new ArrayList<>();
            Reservation reservation11 = new Reservation(new Date());
            reservation11.setBook(book1);
            Reservation reservation12 = new Reservation(new Date());
            reservation12.setBook(book);
            reservationList.add(reservation11);
            reservationList.add(reservation12);
            customer1.setReservations(reservationList);
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
