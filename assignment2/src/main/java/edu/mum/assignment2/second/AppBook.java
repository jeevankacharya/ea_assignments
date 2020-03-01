package edu.mum.assignment2.second;

import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Date;
import java.util.List;

public class AppBook {

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


        //save book in database
        System.err.println("----------------------------------------------------------------------------");
        System.out.println("Saving Book In Database");

        try {

            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            Book book1 = new Book();
            book1.setAuthor("Jeevan Acharya");
            book1.setISBN("1234567");
            book1.setPrice(200.00);
            book1.setTitle("First Book");
            book1.setPublish_date(new Date());
            session.persist(book1);

            Book book2 = new Book();
            book2.setAuthor("Amit Bhattarai");
            book2.setISBN("112233");
            book2.setPrice(200.00);
            book2.setTitle("Second Book");
            book2.setPublish_date(new Date());
            session.persist(book2);

            Book book3 = new Book();
            book3.setAuthor("Sameer Maharjan");
            book3.setISBN("33445566");
            book3.setPrice(200.00);
            book3.setTitle("Third Book");
            book3.setPublish_date(new Date());
            session.persist(book3);

            tx.commit();

        } catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        System.err.println("----------------------------------------------------------------------------");
        System.out.println("Get Book From Database");

        getBooks();
//        Retrieve a book from the database and change its title and price
//         Delete a book (not the one that was just updated)

        System.err.println("----------------------------------------------------------------------------");
        System.out.println("Update and Delete Book From Database");

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            Query query = session.createQuery("from Book where id = 1").setMaxResults(1);
            Book book = (Book) query.uniqueResult();
            book.setTitle("Updated Book");
            book.setPrice(300.00);
            session.update(book);

            //delete Book
            Query deleteQuery = session.createQuery("from Book where id = 2").setMaxResults(1);
            session.delete(deleteQuery.uniqueResult());

            tx.commit();

        } catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        //Retrive All Books After Deleted And Update
        System.err.println("----------------------------------------------------------------------------");
        System.out.println("Get Book After Update and Delete From Database");

        getBooks();
    }

    private static void getBooks() {
        //get book from database

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            List<Book> bookList = session.createQuery("from Book").list();
            bookList.forEach(System.out::println);

        } catch (HibernateException e) {
            tx.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
