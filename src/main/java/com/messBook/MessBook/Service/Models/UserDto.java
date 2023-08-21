package com.messBook.MessBook.Service.Models;

import java.sql.Timestamp;

public class UserDto {
    private String user_name;
    private String name;
    private String role;

    public UserDto(){}

    public UserDto(String user_name, String name, String role) {
        this.user_name = user_name;
        this.name = name;
        this.role = role;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
