package com.dan.demo.springdata.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.dan.demo.springdata.jpa.model.SalesOrder;

import java.util.List;

public interface SalesOrderRepository extends CrudRepository<SalesOrder, Integer> {

    List<SalesOrder> findByTotalLessThanOrderByTotalDesc(double total);

}
