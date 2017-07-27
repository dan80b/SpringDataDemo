package com.dan.demo.springdata.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dan.demo.springdata.jpa.model.Customer;
import com.dan.demo.springdata.jpa.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer find(int customerId) {
        return customerRepository.findOne(customerId);
    }

    public Iterable<Customer> findByName(String name) {
        return customerRepository.findByNameLikeOrderByNameDesc(name);
    }

    public Iterable<Customer> findByProduct(String product) {
        return customerRepository.findByProductOrdered(product);
    }

    public Iterable<Customer> list() {
        return customerRepository.findAll();
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public void delete(int customerId) {
        customerRepository.delete(customerId);
    }
}
