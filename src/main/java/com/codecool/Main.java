package com.codecool;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        BillGenerator billGenerator = new BillGenerator();
        Map<String, Double> productsMap = billGenerator.createPriceProductsMap();

        double resultPrice = billGenerator.computePriceOfBill(productsMap);

        System.out.println("Total price: " + resultPrice + " EUR");
    }
}
