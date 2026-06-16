package com.kiroku;

public class ShopManager {
    // Generates a summary report for customers and orders
    public static void main(String[] args) {
        CustomerManager customerManager = new CustomerManager();
        OrderManager orderManager = new OrderManager();
        ReportManager reportManager = new ReportManager();

        customerManager.addCustomer("John Doe");
        customerManager.addCustomer("Jane Smith");

        orderManager.addOrder("Order1");
        orderManager.addOrder("Order2");

        orderManager.processOrdersForCustomer("John Doe", orderManager.getOrders());

        reportManager.generateReport(customerManager.getCustomers(), orderManager.getOrders());
    }
}
