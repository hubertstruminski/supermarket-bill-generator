package com.codecool;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomFileReaderTest {

    private CustomFileReader customFileReader;

    @BeforeEach
    void setUp() {
        customFileReader = new CustomFileReader();
    }

    @Test
    void testReturnsCorrectNumbersOfProducts() {
        List<String[]> actual = customFileReader.readProducts("products.csv");

        assertEquals(9, actual.size());
    }

    @Test
    void testReturnsCorrectNumbersOfItemsInBasket() {
        List<String> actual = customFileReader.readBasket("basket.csv");

        assertEquals(17, actual.size());
    }
}