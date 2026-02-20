package com.capgemini.MockitoPractice;

import java.util.List;

public class OrderManager {

    private OrderDao orderDao;

    public OrderManager(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    
    public List<Order> fetchAllOrders() {
        return orderDao.getAllOrders();
    }

   
    public boolean addNewOrder(Order order) {
        orderDao.logAction("Order Placed");
        return orderDao.addOrder(order);
    }

    
    public boolean cancelExistingOrder(int id) {
        orderDao.logAction("Order Cancelled");
        return orderDao.cancelOrder(id);
    }

   
    public String checkOffer() {
        return "Regular Offer";
    }

    
    public double processOrder(double price) {
        String offer = checkOffer();

        if (offer.equals("Festival Offer")) {
            return price * 0.80; 
        } else {
            return price * 0.90; 
        }
    }

    
    public static double calculateDiscount(double price) {
        return price * 0.90;
    }
}

