package com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashSet;
import java.util.Set;

public class App {

    public static void main(String[] args) {

        
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("my-persistence-unit");

        
        EntityManager em = emf.createEntityManager();

        try {

            
            User user = new User();
            user.setUsername("Amulya");

           
            Set<String> emails = new HashSet<>();

            emails.add("amulya@gmail.com");
            emails.add("aish.work@gmail.com");
            emails.add("amulya@yahoo.com");

            
            emails.add("ria@gmail.com");

            
            user.setEmails(emails);

            
            em.getTransaction().begin();

            
            em.persist(user);

           
            em.getTransaction().commit();

            System.out.println(" User saved successfully!");

           
            User fetchedUser =
                    em.find(User.class, user.getUserId());

           
            System.out.println("\n User Details");
            System.out.println("User ID   : " + fetchedUser.getUserId());
            System.out.println("Username  : " + fetchedUser.getUsername());

            System.out.println("Emails    : ");
            for (String email : fetchedUser.getEmails()) {
                System.out.println(" - " + email);
            }

        } finally {

           
            em.close();
            emf.close();
        }
    }
}
