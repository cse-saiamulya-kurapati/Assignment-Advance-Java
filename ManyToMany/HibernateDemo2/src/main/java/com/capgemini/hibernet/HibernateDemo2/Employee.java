package com.capgemini.hibernet.HibernateDemo2;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity


@Table(name = "emp_details")

public class Employee {

    @Id
    @Column(name = "emp_id")  
    private int id;

    @Column(name = "emp_name", length = 50, nullable = false)
    private String name;

    @Embedded
    private Address address;

    
    public Employee() {}

    public Employee(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

 
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }
}
