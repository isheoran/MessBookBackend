package com.messBook.MessBook.Entities;

import java.util.UUID;

public class Mess {
    private String id;
    private String name;

    public Mess(){}

    public Mess(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
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
}
