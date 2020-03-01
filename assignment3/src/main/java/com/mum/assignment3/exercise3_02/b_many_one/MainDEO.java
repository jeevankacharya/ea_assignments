package com.mum.assignment3.exercise3_02.b_many_one;
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

public class MainDEO {

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


            Department department = new Department("Computer Department");
            Office office = new Office("Drier");
            Employee employee = new Employee("Jeevan");
            employee.setOffice(office);
            Employee employee1 = new Employee("Sameer");
            employee1.setOffice(office);
            List<Employee> employeeList = new ArrayList<>();
            employeeList.add(employee);
            employeeList.add(employee1);
            department.setEmployees(employeeList);

            session.persist(department);


            Department department1 = new Department("Math Department");
            Office office1 = new Office("Argiro");
            Employee employee11 = new Employee("Amit");
            employee11.setOffice(office1);
            Employee employee12 = new Employee("Nischal");
            employee12.setOffice(office1);
            List<Employee> employeeList1 = new ArrayList<>();
            employeeList1.add(employee11);
            employeeList1.add(employee12);
            department1.setEmployees(employeeList1);

            session.persist(department1);

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
