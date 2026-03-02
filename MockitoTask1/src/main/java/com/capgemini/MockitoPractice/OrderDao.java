package com.capgemini.MockitoPractice;


import java.util.ArrayList;
import java.util.List;



public class OrderDao {

    public List<Order> getAllOrders() {
        return new ArrayList<>(); 
    }

    public boolean addOrder(Order order) {
        return true;
    }

    public boolean cancelOrder(int orderId) {
        return true;
    }


    public final String getDatabaseInfo() {
        return "Connected to MySQL DB";
    }

    
    public void logAction(String action) {
        System.out.println("LOG: " + action);
    }
}
