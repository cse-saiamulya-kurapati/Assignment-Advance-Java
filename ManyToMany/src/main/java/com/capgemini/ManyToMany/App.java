package com.capgemini.ManyToMany;

import jakarta.persistence.*;
import java.util.*;

public class App {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tsx");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Projects
        Project p1 = new Project("Banking system", null);
        Project p2 = new Project("Insurance project", null);

        Set<Project> projectSet = new HashSet<>();
        projectSet.add(p1);
        projectSet.add(p2);

        // Employee
        Employee emp1 = new Employee("John", projectSet);

        // Save Employee (Projects auto saved because of CascadeType.ALL)
        em.persist(emp1);

        em.getTransaction().commit();

        System.out.println("Employee and Projects Saved Successfully!");

        em.close();
        emf.close();
    }
}
