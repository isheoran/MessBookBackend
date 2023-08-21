package com.messBook.MessBook.Entities;

import java.util.UUID;

public class UserSession {
    private String id;
    private String role;
    private int duration;

    public UserSession(String role){
        duration = 1000;
        id = UUID.randomUUID().toString();
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
