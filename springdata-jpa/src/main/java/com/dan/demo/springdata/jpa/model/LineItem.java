package com.dan.demo.springdata.jpa.model;

import javax.persistence.*;

@Entity
@Table(name = "line_item")
public class LineItem {

    private int lineItemId;
    private Product product;
    private SalesOrder order;
    private double price;
    private int quantity;
    private double total;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "line_item_id", length = 10)
    public int getLineItemId() {
        return lineItemId;
    }

    public void setLineItemId(int lineItemId) {
        this.lineItemId = lineItemId;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "product_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "order_id")
    public SalesOrder getOrder() {
        return order;
    }

    public void setOrder(SalesOrder order) {
        this.order = order;
    }

    @Column(name = "price", length = 7, precision = 2)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Column(name = "quantity", length = 3)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Column(name = "total", length = 7, precision = 2)
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "LineItem{" +
                "lineItemId=" + lineItemId +
                ", product=" + product +
                ", order=" + order +
                ", price=" + price +
                ", quantity=" + quantity +
                ", total=" + total +
                '}';
    }
}
