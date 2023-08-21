package com.messBook.MessBook.Entities;

import java.util.UUID;

public class OrderItems {
    private String id;
    private String order_id;
    private String name;
    private Integer price;

    public OrderItems(){}

    public OrderItems(String order_id, String name, Integer price) {
        this.id = UUID.randomUUID().toString();
        this.order_id = order_id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
