package com.dan.demo.springdata.jpa.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dan.demo.springdata.jpa.service.ExportService;

public class App {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-springdata-jpa.xml");

        CustomerClient customerClient = (CustomerClient) context.getBean("customerClient");
        //customerClient.testCustomer();

        ProductClient productClient = (ProductClient) context.getBean("productClient");
        productClient.testProduct();

        //ExportService exportService = (ExportService) context.getBean("exportService");
        //exportService.exportProducts();
    }
}
