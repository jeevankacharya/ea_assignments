package edu.mum.assignment4.inheritance.a;

import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

            Product product1 = new Product("Mobile", "Android Phone");
            Product product2 = new Product("Iphone", "I Phone");

            Customer customer = new Customer("Jeevan", "Acharya");
            List<Order> orderList = new ArrayList<>();

            Order order = new Order(new Date());

            List<OrderLine> orderLineList = new ArrayList<>();
            OrderLine o1 = new OrderLine(2.0);
            o1.setProduct(product1);
            OrderLine o2 = new OrderLine(3.0);
            o2.setProduct(product2);

            orderLineList.add(o1);
            orderLineList.add(o2);
            order.setOrderLines(orderLineList);

            orderList.add(order);
            customer.setOrders(orderList);

            session.persist(customer);


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
