package com.capgemini.hibernet.HibernateDemo2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("myPersistenceUnit");

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            
            Customer newCustomer =
                    new Customer(0, "Amulya", "Chicago");

            em.persist(newCustomer);

        
            Customer foundCustomer =
                    em.find(Customer.class, 300);

            System.out.println("Found Customer: " + foundCustomer);

         
            if (foundCustomer != null) {
                foundCustomer.setName("Arya Updated");
                foundCustomer.setCity("Seattle");

                em.merge(foundCustomer);
            }

           
            Customer customerToDelete =
                    em.find(Customer.class, 101);

            if (customerToDelete != null) {
                em.remove(customerToDelete);
            }

          

            Address addr =
                    new Address("Himachal Pradesh", "Himachal Pradesh", "India");

            Employee emp =
                    new Employee(3, "Pallavi Employee", addr);

            em.persist(emp);

         

            em.getTransaction().commit();

            System.out.println("Data Inserted Successfully...");

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
