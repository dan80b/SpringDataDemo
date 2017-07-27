package com.dan.demo.springdata.jpa.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dan.demo.springdata.jpa.model.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/testContext.xml"})
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository repository;

    @Test
    public void findOne() {
        Customer customer = repository.findOne(1);
        Assert.assertEquals("Kendrick Carran", customer.getName());
    }

    @Test
    public void findAll() {
        Iterable<Customer> customers = repository.findAll();
        long size = customers.spliterator().getExactSizeIfKnown();
        Assert.assertEquals(2, size);
    }

    @Test
    public void findByName() {
        Customer customer = repository.findByName("Kendrick Carran");
        Assert.assertEquals(1, customer.getCustomerId());
    }

    @Test
    public void findByProduct() {
        Iterable<Customer> customers = repository.findByProductOrdered("ASUS%");
        long size = customers.spliterator().getExactSizeIfKnown();
        Assert.assertEquals(2, size);
    }

    @Test
    public void createAndDelete() {
        repository.save(buildCustomer());
        Customer customer = repository.findOne(3);
        Assert.assertEquals("newName", customer.getName());
        repository.delete(3);
        Assert.assertNull(repository.findOne(3));
    }

    @Test
    public void update() {
        Customer initial = repository.findOne(2);
        initial.setName("updatedName");
        repository.save(initial);
        Customer updated = repository.findOne(2);
        Assert.assertEquals("updatedName", updated.getName());
    }

    private Customer buildCustomer() {
        Customer customer = new Customer();
        customer.setName("newName");
        customer.setAddress("newAddress");
        customer.setPhone("newPhone");
        return customer;
    }
}
