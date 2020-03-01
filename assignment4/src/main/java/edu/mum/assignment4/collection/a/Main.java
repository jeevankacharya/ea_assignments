package edu.mum.assignment4.collection.a;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.*;

public class Main {

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

            Employee employee = new Employee("Jeevan", "Acharya");
            Set<Laptop> list = new HashSet<>();
            list.add(new Laptop("Dell", "MINI"));
            list.add(new Laptop("LENEVO", "LARGE"));
            employee.setLaptops(list);
            session.persist(employee);
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
