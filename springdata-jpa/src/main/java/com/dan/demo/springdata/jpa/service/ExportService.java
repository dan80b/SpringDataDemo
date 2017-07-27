package com.dan.demo.springdata.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dan.demo.springdata.jpa.model.Product;
import com.dan.demo.springdata.jpa.repository.ProductRepository;
import com.dan.demo.springdata.jpa.util.CsvProductWriter;

import java.io.IOException;

@Service
public class ExportService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CsvProductWriter csvProductWriter;

    public void exportProducts() {
        Iterable<Product> products = productRepository.findAll();
        try {
            csvProductWriter.writeProducts(products);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
