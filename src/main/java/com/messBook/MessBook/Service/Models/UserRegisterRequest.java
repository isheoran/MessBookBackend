package com.messBook.MessBook.Service.Models;

import java.sql.Timestamp;

public class UserRegisterRequest {
    private String user_name;
    private String roll_number;
    private String name;
    private String password;
    private String role;

    public UserRegisterRequest(){}

    public UserRegisterRequest(String user_name, String roll_number, String name, String password, String role) {
        this.user_name = user_name;
        this.roll_number = roll_number;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getRoll_number() {
        return roll_number;
    }

    public void setRoll_number(String roll_number) {
        this.roll_number = roll_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
