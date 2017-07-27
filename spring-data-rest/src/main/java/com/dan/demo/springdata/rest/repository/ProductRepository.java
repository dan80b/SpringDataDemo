package com.dan.demo.springdata.rest.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.dan.demo.springdata.rest.model.Product;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

    List<Product> findByNameLike(@Param("name") String name);

    List<Product> findByPriceGreaterThanOrderByPriceDesc(@Param("price") Double price);
}
