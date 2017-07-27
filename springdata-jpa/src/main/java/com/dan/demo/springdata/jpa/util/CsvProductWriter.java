package com.dan.demo.springdata.jpa.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.dan.demo.springdata.jpa.model.Product;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CsvProductWriter {

    private static final char SEPARATOR = ';';
    
    private String file = "D:\\tmp\\products.csv";

    public void writeProducts(Iterable<Product> products) throws IOException {
        List<String> lines = new ArrayList<>();
        for (Product product : products) {
            lines.add(buildProductLine(product));
        }
        writeLines(lines);
    }

    private String buildProductLine(Product product) {
        StringBuilder line = new StringBuilder();
        line.append(product.getProductId()).append(SEPARATOR)
                .append(product.getName()).append(SEPARATOR)
                .append(product.getDescription()).append(SEPARATOR)
                .append(product.getPrice());
        return line.toString();
    }

    private void writeLines(Iterable<String> lines) throws IOException {
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (String line : lines) {
                fileWriter.append(line);
                fileWriter.append(System.lineSeparator());
            }
        }
    }
}
