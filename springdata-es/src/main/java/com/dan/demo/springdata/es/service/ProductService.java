package com.dan.demo.springdata.es.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import com.dan.demo.springdata.es.model.Product;
import com.dan.demo.springdata.es.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    public Product find(String productId) {
        return productRepository.findOne(productId);
    }

    public Iterable<Product> findByName(String name) {
        return productRepository.findByNameLikeOrderByPrice(name);
    }

    public Iterable<Product> list() {
        return productRepository.findAll();
    }

    public void createIndex() {
        elasticsearchTemplate.createIndex(Product.class);
    }

    public void indexProduct(Product product) {
        productRepository.save(product);
    }
}
