package edu.mum.assignment4.collection.c;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.*;

public class MainSS {

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

            School school = new School("MIU");

            Map<Integer,Student> list = new HashMap<>();
            list.put(1,new Student("Jeevan","Acharya"));
            list.put(2,new Student("Sameer","Maharjan"));
            list.put(3,new Student("Hanok","Hamza"));

            school.setStudents(list);
            session.persist(school);

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
