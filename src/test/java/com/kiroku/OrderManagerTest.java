package com.kiroku;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for OrderManager.
 * Covers adding orders, retrieving the list, and processing logic.
 */
class OrderManagerTest {

    private OrderManager orderManager;

    // Initialize a fresh instance before each test
    @BeforeEach
    void setUp() {
        orderManager = new OrderManager();
    }

    // --- AddOrder tests ---

    @Test
    @DisplayName("AddOrder - should add a single order to the list")
    void addOrder_singleOrder_shouldBeInList() {
        orderManager.addOrder("ORD-001");

        List<String> orders = orderManager.getOrders();

        assertEquals(1, orders.size());
        assertEquals("ORD-001", orders.get(0));
    }

    @Test
    @DisplayName("AddOrder - should add multiple orders preserving order")
    void addOrder_multipleOrders_shouldPreserveInsertionOrder() {
        orderManager.addOrder("ORD-001");
        orderManager.addOrder("ORD-002");
        orderManager.addOrder("ORD-003");

        List<String> orders = orderManager.getOrders();

        assertEquals(3, orders.size());
        assertEquals("ORD-001", orders.get(0));
        assertEquals("ORD-002", orders.get(1));
        assertEquals("ORD-003", orders.get(2));
    }

    @Test
    @DisplayName("AddOrder - should allow duplicate order names")
    void addOrder_duplicateOrder_shouldAddBoth() {
        orderManager.addOrder("ORD-001");
        orderManager.addOrder("ORD-001");

        assertEquals(2, orderManager.getOrders().size());
    }

    // --- GetOrders tests ---

    @Test
    @DisplayName("GetOrders - should return empty list when no orders added")
    void getOrders_noOrdersAdded_shouldReturnEmptyList() {
        List<String> orders = orderManager.getOrders();

        assertNotNull(orders);
        assertTrue(orders.isEmpty());
    }

    // --- ProcessOrders tests ---

    @Test
    @DisplayName("ProcessOrders - should complete without error for a valid list")
    void processOrders_validList_shouldNotThrow() {
        List<String> orders = Arrays.asList("ORD-001", "ORD-002");

        assertDoesNotThrow(() -> orderManager.processOrders(orders));
    }

    @Test
    @DisplayName("ProcessOrders - should handle an empty list gracefully")
    void processOrders_emptyList_shouldNotThrow() {
        assertDoesNotThrow(() -> orderManager.processOrders(Collections.emptyList()));
    }

    // --- ProcessOrdersForCustomer tests ---

    @Test
    @DisplayName("ProcessOrdersForCustomer - should process orders for a given customer")
    void processOrdersForCustomer_validInputs_shouldNotThrow() {
        List<String> orders = Arrays.asList("ORD-001", "ORD-002");

        assertDoesNotThrow(() -> orderManager.processOrdersForCustomer("Alice", orders));
    }

    @Test
    @DisplayName("ProcessOrdersForCustomer - should handle empty order list")
    void processOrdersForCustomer_emptyOrders_shouldNotThrow() {
        assertDoesNotThrow(
            () -> orderManager.processOrdersForCustomer("Alice", Collections.emptyList())
        );
    }
}
