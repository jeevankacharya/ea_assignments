package com.mum.assignment3.exercise3_02.b_one_many;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.DependantValue;
import org.hibernate.service.ServiceRegistry;

import java.util.ArrayList;
import java.util.List;

public class Main {
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

            // Create new instance of Car and set values in it
            Employee employee1 = new Employee("Jeevan");
            Employee employee2 = new Employee("Sameer");
            Employee employee3 = new Employee("Amit");
            Employee employee4 = new Employee("Nischal");
            Employee employee5 = new Employee("Sagar");
            List<Employee> employeeslist = new ArrayList<>();
            employeeslist.add(employee1);
            employeeslist.add(employee2);
            employeeslist.add(employee3);
            employeeslist.add(employee4);

            Department department = new Department("Computer");
           department.setEmployeeList(employeeslist);
            session.save(department);
//
//            Department department2 = new Department("Math");
//            department2.setEmployeeList(employee5);
//            session.persist(department2);


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

      /*  try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            // retieve all cars
            @SuppressWarnings("unchecked")
            List<Department> departmentList = session.createQuery("from Department").list();
            departmentList.forEach(System.out::println);
//            for (Car car : carList) {
//                System.out.println("brand= " + car.getBrand() + ", year= "
//                        + car.getYear() + ", price= " + car.getPrice());
//            }
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

        // Close the SessionFactory (not mandatory)
        sessionFactory.close();
        System.exit(0);*/
    }
}
