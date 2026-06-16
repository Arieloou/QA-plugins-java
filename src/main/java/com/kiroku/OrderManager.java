package com.kiroku;

import java.util.ArrayList;
import java.util.List;

import java.util.logging.Logger;

public class OrderManager {
    // We use an private field
    // because it can be accessed from outside
    // with a public getter method
    private List<String> orderList = new ArrayList<>();

    // Logger to register operations
    private static Logger logger = Logger.getLogger(OrderManager.class.getName());

    // Adds an order to the list
    public void addOrder(String order) {
        orderList.add(order);
        // We replace all the system.println() for a logger.info() 
        // because it was a recomendation of SonarQube
        logger.info(() -> "Order added: " + order);
    }

    // Processes all orders for a specific customer
    public void processOrdersForCustomer(String customer, List<String> orders) {
        // We replace all the system.println() for a logger.info() 
        // because it was a recomendation of SonarQubes
        logger.info(() -> "Processing orders for: " + customer);
        processOrders(orders);
    }

    // Process all orders
    public void processOrders(List<String> orders) {
        // We replace the for loop with an enhanced for loop
        // because it is more readable and efficient
        for (String order : orders) {
            logger.info(() -> "Order: " + order);
        }
    }

    // We return the order list 
    // beacause the list is private and we 
    // shouldn't access it from outside
    public List<String> getOrders() {
        return orderList;
    }
}
