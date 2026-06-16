package com.kiroku;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for ReportManager.
 * Covers report generation with different customer/order combinations.
 */
class ReportManagerTest {

    private ReportManager reportManager;

    // Initialize a fresh instance before each test
    @BeforeEach
    void setUp() {
        reportManager = new ReportManager();
    }

    // --- GenerateReport tests ---

    @Test
    @DisplayName("GenerateReport - should complete successfully with valid data")
    void generateReport_validData_shouldNotThrow() {
        List<String> customers = Arrays.asList("Alice", "Bob");
        List<String> orders = Arrays.asList("ORD-001", "ORD-002");

        assertDoesNotThrow(() -> reportManager.generateReport(customers, orders));
    }

    @Test
    @DisplayName("GenerateReport - should handle empty customers list")
    void generateReport_emptyCustomers_shouldNotThrow() {
        List<String> orders = Arrays.asList("ORD-001", "ORD-002");

        assertDoesNotThrow(() -> reportManager.generateReport(Collections.emptyList(), orders));
    }

    @Test
    @DisplayName("GenerateReport - should handle empty orders list")
    void generateReport_emptyOrders_shouldNotThrow() {
        List<String> customers = Arrays.asList("Alice", "Bob");

        assertDoesNotThrow(
            () -> reportManager.generateReport(customers, Collections.emptyList())
        );
    }

    @Test
    @DisplayName("GenerateReport - should handle both lists empty")
    void generateReport_bothListsEmpty_shouldNotThrow() {
        assertDoesNotThrow(
            () -> reportManager.generateReport(Collections.emptyList(), Collections.emptyList())
        );
    }
}
