package com.dan.demo.springdata.jpa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dan.demo.springdata.jpa.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    String FIND_BY_PRODUCT = "select c from SalesOrder o inner join o.customer c \n" +
            "where o.orderId in (select l.order.orderId from LineItem l inner join l.product p where p.name like ?1)";

    String FIND_BY_PRODUCT_SQL = "select * from customer c inner join sales_order o on c.customer_id = o.customer_id \n" +
            "where o.order_id in (select order_id from line_item l inner join product p on l.product_id = p.product_id where p.name like ?1)";

    Customer findByName(String name);

    Iterable<Customer> findByNameLikeOrderByNameDesc(String name);

    @Query(value = FIND_BY_PRODUCT_SQL, nativeQuery = true)
    Iterable<Customer> findByProductOrdered(String product);
}
