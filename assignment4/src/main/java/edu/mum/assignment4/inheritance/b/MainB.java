package edu.mum.assignment4.inheritance.b;

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

public class MainB {

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

            DVD product1 = new DVD("DVD", "Hunter");
            product1.setGenre("Action");

            CD product2 = new CD("CD", "Jumanji");
            product2.setArtist("THE ROCK");

            Book product3 = new Book("Book", "The Knight");
            product3.setTitle("The Knight KING");

            Customer1 customer = new Customer1("Jeevan", "Acharya");
            List<Order1> order1List = new ArrayList<>();

            Order1 order1 = new Order1(new Date());

            List<OrderLine1> orderLineList = new ArrayList<>();
            OrderLine1 o1 = new OrderLine1(2.0);
            o1.setProduct(product1);
            OrderLine1 o2 = new OrderLine1(3.0);
            o2.setProduct(product2);
            OrderLine1 o3 = new OrderLine1(3.0);
            o3.setProduct(product3);


            orderLineList.add(o1);
            orderLineList.add(o2);
            orderLineList.add(o3);
            order1.setOrderLines(orderLineList);

            order1List.add(order1);
            customer.setOrder1s(order1List);

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
        // get Data

//        session = sessionFactory.openSession();
//        tx = session.beginTransaction();

//        List<Customer> customer11 = session.createQuery("from customer").list();
//        Customer customer = customer11.get(0);
//        System.out.println(customer.getFirstName()+ " "+ customer.getLastName());
//        for(Order order : customer.getOrders()){
//            System.err.println("---------------------------------------------------------------");
//            System.out.println(order.getDate());
//
//            for(OrderLine orderLine : order.getOrderLines()){
//                System.out.println(orderLine.getQuantity());
//                if(orderLine.getProduct() instanceof CD){
//                    System.out.println("CD "+  ((CD) orderLine.getProduct()).getArtist());
//                }else if(orderLine.getProduct() instanceof  DVD){
//                    System.out.println("CD "+  ((DVD) orderLine.getProduct()).getGenre());
//
//                }else{
//                    System.out.println("CD "+  ((DVD) orderLine.getProduct()).getGenre());
//
//                }
//            }
//        }
    }

}
