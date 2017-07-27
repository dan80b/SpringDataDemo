package com.dan.demo.springdata.jpa.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dan.demo.springdata.jpa.model.LineItem;
import com.dan.demo.springdata.jpa.model.Product;
import com.dan.demo.springdata.jpa.model.SalesOrder;
import com.dan.demo.springdata.jpa.service.ProductService;

@Component
public class ProductClient {

    @Autowired
    private ProductService productService;

    public void testProduct() {

        //productService.save(product());

        /*for (Product product : productService.list()) {
            System.out.println(product);
        }*/

        for (SalesOrder order : productService.findByTotal()) {
            System.out.println(order);
        }

        /*SalesOrder order = productService.findOrder(1);

        for (LineItem item : order.getLineItems()) {
            System.out.println(item);
        }*/


        //order.getLineItems().add(lineItem(order));

        //productService.updateOrder(order);


        //System.out.println(productService.find(5));

    }

    private LineItem lineItem(SalesOrder order) {
        LineItem item = new LineItem();
        Product product = productService.find(5);
        item.setOrder(order);
        item.setProduct(product);
        item.setQuantity(2);
        item.setTotal(1000);
        return item;
    }

    private Product product() {
        Product product = new Product();
        product.setName("name");
        product.setDescription("desc");
        product.setPrice(1000);
        return product;
    }

}
