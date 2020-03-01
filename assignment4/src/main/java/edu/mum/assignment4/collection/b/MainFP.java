package edu.mum.assignment4.collection.b;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.*;

public class MainFP {

    private static SessionFactory sessionFactory;

    static {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    private static Session session = null;
    private static Transaction tx = null;

    public static void main(String[] args) {


        try {

            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            Passenger passenger = new Passenger("Jeevan Acharya");
            List<Flight> flightList = new ArrayList<>();
            Flight f1 = new Flight("Flight-1", "KTM", "USA", new Date());
            Flight f2 = new Flight("Flight-2", "USA", "KTM", new Date());
            Flight f3 = new Flight("Flight-3", "IND", "USA", new Date());
            flightList.add(f1);
            flightList.add(f2);
            flightList.add(f3);
            passenger.setFlights(flightList);
            session.persist(passenger);

            Passenger passenger1 = new Passenger("Sameer Maharjan");
            List<Flight> flightList1 = new ArrayList<>();
            Flight f11 = new Flight("Flight-1", "KTM", "USA", new Date());
            Flight f21 = new Flight("Flight-2", "USA", "KTM", new Date());
            Flight f31 = new Flight("Flight-3", "IND", "USA", new Date());
            flightList1.add(f11);
            flightList1.add(f21);
            flightList1.add(f31);
            passenger1.setFlights(flightList1);
            session.persist(passenger1);
            tx.commit();

        } catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
