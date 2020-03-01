package com.mum.assignment3.exercise3_02.b_many_many;

import com.mum.assignment3.exercise3_02.ou_many_one.Book;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainCS {

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

            Student student = new Student("Jeevan", "Acharya");
            Student student1 = new Student("Sameer", "Maharjan");
            Student student2 = new Student("Ceaser", "Paudel");



            Course course = new Course("123","English");
            Course course1 = new Course("345","Computer");
            Course course2 = new Course("222","Math");


            List<Student> studentList = new ArrayList<>();
            studentList.add(student);
            studentList.add(student1);
            course.setStudentList(studentList);
            session.persist(course);

            List<Course> courseList = new ArrayList<>();
            courseList.add(course1);
            courseList.add(course2);
            student2.setCourseList(courseList);
            session.persist(student2);


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
