package com.capgemini.hibernate.hibernatedemo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Bookstore;

public class App {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Bookstore.class)
                .buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Bookstore b1 = new Bookstore("Java Book", "Amulya", 500);

        session.persist(b1);

        tx.commit();

        session.close();
        factory.close();

        System.out.println(" Insert Successful!");
    }
}
