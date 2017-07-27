package com.dan.demo.springdata.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dan.demo.springdata.jpa.model.Product;
import com.dan.demo.springdata.jpa.model.SalesOrder;
import com.dan.demo.springdata.jpa.repository.ProductRepository;
import com.dan.demo.springdata.jpa.repository.SalesOrderRepository;
import com.dan.demo.springdata.jpa.util.CsvProductWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SalesOrderRepository salesOrderRepository;


    public Iterable<SalesOrder> findByTotal() {
        return salesOrderRepository.findByTotalLessThanOrderByTotalDesc(5000);
    }

    public Product find(int id) {
        return productRepository.findOne(id);
    }

    public SalesOrder findOrder(int id) {
        return salesOrderRepository.findOne(id);
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public void updateOrder(SalesOrder order) {
        salesOrderRepository.save(order);
    }

    public Iterable<SalesOrder> listOrders() {
        return salesOrderRepository.findAll();
    }

    public Iterable<Product> list() {
        return productRepository.findAll();
    }

    public List<Product> list(int page, int size) {
        Sort sort = new Sort(Sort.Direction.ASC, "price");
        Page<Product> list = productRepository.findAll(new PageRequest(page, size, sort));
        return list.getContent();
    }

    public Iterable<Product> sortByPrice() {
        Sort sort = new Sort(Sort.Direction.DESC, "price");
        return productRepository.findAll(sort);
    }

    public List<String> findByName(String name) {
        List<String> names = new ArrayList<>();
        try (Stream<Product> stream = productRepository.streamAll()) {
            stream
                .filter(product -> product.getName().startsWith(name))
                .map(Product::getName)
                .forEach(names::add);
        }
        return names;
    }


}
