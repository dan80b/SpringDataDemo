package com.dan.demo.springdata.es.util;

import org.springframework.stereotype.Component;

import com.dan.demo.springdata.es.model.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class CsvProductReader {

    private static final String SEPARATOR = ";";

    private String file = "D:\\tmp\\products.csv";

    public List<Product> readProducts() throws IOException {
        List<Product> products = new ArrayList<>();
        List<String> lines = readLines();
        for (String line : lines) {
            products.add(parseLine(line));
        }
        return products;
    }

    private List<String> readLines() throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }

    private Product parseLine(String line) {
        String[] productLine = line.split(SEPARATOR);
        Product product = new Product();
        product.setProductId(UUID.randomUUID().toString());
        product.setName(productLine[1]);
        product.setDescription(productLine[2]);
        product.setPrice(Double.parseDouble(productLine[3]));
        return product;
    }
}
