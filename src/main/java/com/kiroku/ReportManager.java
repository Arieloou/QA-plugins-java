package com.kiroku;

import java.util.List;
import java.util.logging.Logger;

public class ReportManager {
    // Generates a summary report for customers and orders
    public void generateReport(List<String> customers, List<String> orders) {
        // Logger to register operations
        Logger logger = Logger.getLogger(ReportManager.class.getName());

        CustomerManager customerManager = new CustomerManager();
        OrderManager orderManager = new OrderManager();

        // We replace all the system.println() for a logger.info() 
        // because it was a recomendation of SonarQube
        logger.info("Processing customers");
        // We call the method processCustomers from CustomerManager
        // and we pass the customers list to it
        customerManager.processCustomers(customers);

        // We replace all the system.println() for a logger.info() 
        // because it was a recomendation of SonarQube
        logger.info("Processing orders");
        // We call the method processOrders from OrderManager
        // and we pass the orders list to it
        orderManager.processOrders(orders);
    }
}

