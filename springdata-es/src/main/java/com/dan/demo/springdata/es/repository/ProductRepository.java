package com.dan.demo.springdata.es.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import com.dan.demo.springdata.es.model.Product;

public interface ProductRepository extends ElasticsearchCrudRepository<Product, String> {

    Iterable<Product> findByNameLikeOrderByPrice(String name);
}
