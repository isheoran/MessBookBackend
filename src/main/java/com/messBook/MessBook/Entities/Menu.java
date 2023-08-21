package com.messBook.MessBook.Entities;

import java.util.UUID;

public class Menu {
    private String id;
    private String name;
    private Integer price;
    private String mess_id;

    public Menu(){}

    public Menu(String name, Integer price, String mess_id) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.mess_id = mess_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getMess_id() {
        return mess_id;
    }

    public void setMess_id(String mess_id) {
        this.mess_id = mess_id;
    }
}
