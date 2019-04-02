package com.codecool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BillGenerator {

    private CustomFileReader customFileReader;

    public BillGenerator() {
        customFileReader = new CustomFileReader();
    }

    public Map<String, Double> createPriceProductsMap() {
        List<String[]> productsList = customFileReader.readProducts("products.csv");

        Map<String, Double> productsMap = new HashMap<>();

        for(String[] element: productsList) {

            String barCode = element[0];
            int amount = Integer.parseInt(element[2]);
            double price = Double.parseDouble(element[3]) / amount;

            if(barCode.equals("1001") && amount == 2) {
                continue;
            }
            productsMap.put(barCode, price);
        }
        return productsMap;
    }

    public double computePriceOfBill(Map<String, Double> productsMap) {
        List<String> basketList = customFileReader.readBasket("basket.csv");

        int countBeers = 0;
        double totalPrice = 0;
        double beerPrice = 0;
        for(String item: basketList) {
            for (Map.Entry<String, Double> entry : productsMap.entrySet()) {
                String barCode = entry.getKey();
                double price = entry.getValue();

                if(item.equals(barCode)) {
                    if(barCode.equals("1001")) {
                        countBeers++;
                        beerPrice = price;
                        continue;
                    }
                    totalPrice += price;
                }
            }
        }
        if(countBeers % 2 == 0) {
            totalPrice += countBeers * 2.00;
        } else if(countBeers % 2 == 1) {
            int amountBeers = countBeers / 2;
            int remainderBeers = countBeers % 2;

            totalPrice += amountBeers * 2 * 2.00 + remainderBeers * beerPrice;
        }
        return totalPrice;
    }
}
