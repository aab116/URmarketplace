package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProductTest {

    @Test
    void constructorAndGettersReturnAssignedValues() {
        // Create one product using the full constructor.
        Product product = new Product(7, "Monitor", "27-inch display", 180.0, 150.0, 12);

        // The getters should return the same values passed into the constructor.
        assertEquals(7, product.getId());
        assertEquals("Monitor", product.getTitle());
        assertEquals("27-inch display", product.getDescription());
        assertEquals(180.0, product.getPrice(), 0.0001);
        assertEquals(150.0, product.getBiddingPrice(), 0.0001);
        assertEquals(12, product.getSellerId());
    }

    @Test
    void toStringContainsKeySummaryFields() {
        // Build a product and convert it to text.
        Product product = new Product(7, "Monitor", "27-inch display", 180.0, 150.0, 12);
        String text = product.toString();

        // The string output should include the main identifying fields.
        assertTrue(text.contains("id=7"));
        assertTrue(text.contains("title='Monitor'"));
        assertTrue(text.contains("price=180.0"));
        assertTrue(text.contains("sellerId=12"));
    }
}
