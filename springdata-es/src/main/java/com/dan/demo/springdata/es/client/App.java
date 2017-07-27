package com.dan.demo.springdata.es.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dan.demo.springdata.es.service.ImportService;

public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-springdata-es.xml");
        ProductClient productClient = (ProductClient) context.getBean("productClient");
        productClient.testProduct();
    }
}
