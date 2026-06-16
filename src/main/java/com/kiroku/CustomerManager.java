package com.kiroku;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CustomerManager {
    // We use an private field
    // because it can be accessed from outside
    // with a public getter method
    private List<String> customerList = new ArrayList<>();

    // Logger to register operations
    private static Logger logger = Logger.getLogger(CustomerManager.class.getName());

    // Adds a customer to the list
    public void addCustomer(String name) {
        customerList.add(name);
        // We replace all the system.println() for a logger.info()
        // because it was a recomendation of SonarQube
        logger.info(() -> "Customer added: " + name);
    }

    // Processes all orders for all customers
    public void processCustomers(List<String> customers) {
        // We replace the for loop with an enhanced for loop
        // because it is more readable and efficient
        for (String customer : customers) {
            logger.info(() -> "Customer: " + customer);
        }
    }

    // We return the customer list
    // beacause the list is private and we
    // shouldn't access it from outside
    public List<String> getCustomers() {
        return customerList;
    }
}
