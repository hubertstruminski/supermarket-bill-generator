package com.codecool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class CustomFileReader {

    private List<String[]> productsList;
    private List<String> basketList;
    private final String path = "/home/hubert/Pulpit/supermarket-bill-generator/src/main/resources/";

    public CustomFileReader() {
        productsList = new ArrayList<>();
        basketList = new ArrayList<>();
    }

    public List<String[]> readProducts(String fileName) {
        try(BufferedReader br = new BufferedReader(new FileReader(path + fileName))) {

            String line;
            while ((line = br.readLine()) != null) {
                productsList.add(line.trim().split(","));
            }
        } catch (IOException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return productsList;
    }

    public List<String> readBasket(String fileName) {
        try {
            basketList = Files.readAllLines(new File(path + fileName).toPath(), Charset.forName("utf-8"));
        } catch (IOException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return basketList;
    }
}
