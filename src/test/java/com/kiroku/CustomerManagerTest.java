package com.kiroku;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for CustomerManager.
 * Covers adding customers, retrieving the list, and processing.
 */
class CustomerManagerTest {

    private CustomerManager customerManager;

    // Initialize a fresh instance before each test
    @BeforeEach
    void setUp() {
        customerManager = new CustomerManager();
    }

    // --- AddCustomer tests ---

    @Test
    @DisplayName("AddCustomer - should add a single customer to the list")
    void addCustomer_singleCustomer_shouldBeInList() {
        customerManager.addCustomer("Alice");

        List<String> customers = customerManager.getCustomers();

        assertEquals(1, customers.size());
        assertEquals("Alice", customers.get(0));
    }

    @Test
    @DisplayName("AddCustomer - should add multiple customers preserving order")
    void addCustomer_multipleCustomers_shouldPreserveInsertionOrder() {
        customerManager.addCustomer("Alice");
        customerManager.addCustomer("Bob");
        customerManager.addCustomer("Charlie");

        List<String> customers = customerManager.getCustomers();

        assertEquals(3, customers.size());
        assertEquals("Alice", customers.get(0));
        assertEquals("Bob", customers.get(1));
        assertEquals("Charlie", customers.get(2));
    }

    @Test
    @DisplayName("AddCustomer - should allow duplicate names")
    void addCustomer_duplicateName_shouldAddBoth() {
        customerManager.addCustomer("Alice");
        customerManager.addCustomer("Alice");

        List<String> customers = customerManager.getCustomers();

        assertEquals(2, customers.size());
    }

    // --- GetCustomers tests ---

    @Test
    @DisplayName("GetCustomers - should return empty list when no customers added")
    void getCustomers_noCustomersAdded_shouldReturnEmptyList() {
        List<String> customers = customerManager.getCustomers();

        assertNotNull(customers);
        assertTrue(customers.isEmpty());
    }

    // --- ProcessCustomers tests ---

    @Test
    @DisplayName("ProcessCustomers - should complete without error for a valid list")
    void processCustomers_validList_shouldNotThrow() {
        List<String> customers = Arrays.asList("Alice", "Bob");

        // ProcessCustomers only logs; verify it runs without exceptions
        assertDoesNotThrow(() -> customerManager.processCustomers(customers));
    }

    @Test
    @DisplayName("ProcessCustomers - should handle an empty list gracefully")
    void processCustomers_emptyList_shouldNotThrow() {
        assertDoesNotThrow(() -> customerManager.processCustomers(Collections.emptyList()));
    }
}
