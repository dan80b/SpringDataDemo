package com.dan.demo.springdata.jpa.model;

import java.sql.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "sales_order")
public class SalesOrder {

    private int orderId;
    private Customer customer;
    private Date date;
    private double total;
    private List<LineItem> lineItems;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id", length = 10)
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Column(name = "date", length = 2)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "total", length = 7, precision = 2)
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "order", fetch = FetchType.EAGER)
    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    @Override
    public String toString() {
        return "SalesOrder{" +
                "total=" + total +
                ", date=" + date +
                ", customer=" + customer +
                ", orderId=" + orderId +
                '}';
    }
}
