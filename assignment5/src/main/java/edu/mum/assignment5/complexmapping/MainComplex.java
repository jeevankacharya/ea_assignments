package edu.mum.assignment5.complexmapping;

import edu.mum.assignment5.complexmapping.model.Appointment;
import edu.mum.assignment5.complexmapping.model.Doctor;
import edu.mum.assignment5.complexmapping.model.Patient;
import edu.mum.assignment5.complexmapping.model.Payment;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class MainComplex {

    private static SessionFactory sessionFactory;

    static {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static void main(String[] args) {
        Session session = null;
        Transaction tx = null;
        try {

            session = sessionFactory.openSession();
            tx = session.beginTransaction();


            Appointment appointment = new Appointment("15/05/08");
            Doctor doctor = new Doctor("Eye Doctor", "Frank", "Brown");
            Patient patient = new Patient("John Doe", "100 Main Street", "23114", "Boston");
            Payment payment = new Payment("12/06/08", 100);
            appointment.setDoctor(doctor);
            appointment.setPatient(patient);
            appointment.setPayment(payment);

            session.persist(appointment);

            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        try {

            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            Query query = session.createQuery("from Appointment");
            Appointment appointment1 = (Appointment) query.list().get(0);
            System.out.println(appointment1);

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
