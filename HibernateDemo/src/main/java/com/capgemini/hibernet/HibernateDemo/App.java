package com.capgemini.hibernet.HibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {

       
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        
        SessionFactory factory = cfg.buildSessionFactory();

        Session session = factory.openSession();

        Transaction tx = null;

        try {
            
            tx = session.beginTransaction();

            
            Customer newCustomer = new Customer();
            newCustomer.setId(11);
            newCustomer.setName("Alice Johnson");
            newCustomer.setCity("Chicago");

            session.save(newCustomer);
            System.out.println("Inserted: " + newCustomer.getName());

           
            Customer foundCustomer =
                    session.get(Customer.class, 5);

            if (foundCustomer != null) {
                System.out.println(
                        "Found: " +
                        foundCustomer.getName() + " " +
                        foundCustomer.getCity());
            }

          
            if (foundCustomer != null) {

                foundCustomer.setCity("Delhi");
                session.update(foundCustomer);

                System.out.println("Updated Customer ID 5");
            }

        
            Customer deleteCustomer =
                    session.get(Customer.class, 3);

            if (deleteCustomer != null) {

                session.delete(deleteCustomer);
                System.out.println("Deleted Customer ID 3");
            }

           
            tx.commit();

        } catch (Exception e) {

            if (tx != null) tx.rollback();
            e.printStackTrace();

        } finally {

            session.close();
            factory.close();
        }

        System.out.println("CRUD Operations Completed!");
    }
}
