package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BillGeneratorTest {

    private BillGenerator billGenerator;

    @BeforeEach
    void setUp() {
        billGenerator = new BillGenerator();
    }

    @Test
    void testMapWithProductsContainsAllProducts() {
        Map<String, Double> actual = billGenerator.createPriceProductsMap();

        assertEquals(8, actual.size());
    }

    @Test
    void testReturnsCorrectTotalPriceOfProductsInBasket() {
        Map<String, Double> productsMap = billGenerator.createPriceProductsMap();
        double actual = billGenerator.computePriceOfBill(productsMap);

        assertEquals(48.59, actual);
    }
}