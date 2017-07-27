package com.dan.demo.springdata.jpa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.dan.demo.springdata.jpa.model.Product;

import java.util.stream.Stream;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

    @Query("select p from Product p")
    Stream<Product> streamAll();
}
