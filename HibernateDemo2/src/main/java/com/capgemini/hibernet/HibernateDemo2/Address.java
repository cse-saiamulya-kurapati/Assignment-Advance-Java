package com.capgemini.hibernet.HibernateDemo2;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

    @Column(name = "city_name", length = 40)
    private String city;

    @Column(name = "state_name", length = 40)
    private String state;

    @Column(name = "country_name", length = 40)
    private String country;

    public Address() {}

    public Address(String city, String state, String country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }

    
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
}
