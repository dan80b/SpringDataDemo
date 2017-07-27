package com.dan.demo.springdata.jpa.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dan.demo.springdata.jpa.model.Customer;
import com.dan.demo.springdata.jpa.service.CustomerService;

import java.util.List;

@Component
public class CustomerClient {

    @Autowired
    private CustomerService customerService;

    public void testCustomer() {

        customerService.save(customer1());

    }

    private Customer customer1() {
        return customer("Legolas Kyler234", "71 Pilgrim Avenue Chevy Chase, MD 457535", "202-555-531");
    }

    private Customer customer(String name, String address, String phone) {
        Customer customer = new Customer();
        customer.setCustomerId(2);
        customer.setName(name);
        customer.setAddress(address);
        customer.setPhone(phone);
        return customer;
    }
}
