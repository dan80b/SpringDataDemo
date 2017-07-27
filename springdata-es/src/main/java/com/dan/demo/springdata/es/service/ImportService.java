package com.dan.demo.springdata.es.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dan.demo.springdata.es.model.Product;
import com.dan.demo.springdata.es.repository.ProductRepository;
import com.dan.demo.springdata.es.util.CsvProductReader;

import java.io.IOException;
import java.util.List;

@Service
public class ImportService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CsvProductReader csvProductReader;

    public void importProducts() {
        try {
            List<Product> products = csvProductReader.readProducts();
            for (Product product : products) {
                productRepository.save(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
