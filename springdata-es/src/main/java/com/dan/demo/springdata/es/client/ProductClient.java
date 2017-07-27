package com.dan.demo.springdata.es.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Component;

import com.dan.demo.springdata.es.model.Product;
import com.dan.demo.springdata.es.service.ProductService;

import java.util.UUID;

@Component
public class ProductClient {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private ProductService productService;

    public void testProduct() {

        Iterable<Product> products = productService.list();
        for (Product product : products) {
            System.out.println(product);
        }

        //productService.indexProduct(product());
    }

    private Product product() {
        Product product = new Product();
        product.setProductId(UUID.randomUUID().toString());
        product.setName("Spring in Action");
        product.setDescription("Spring book");
        product.setPrice(180);
        return product;
    }

    public void createIndex() {
        elasticsearchTemplate.createIndex(Product.class);
    }
}
