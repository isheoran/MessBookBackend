package com.messBook.MessBook.Entities;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

public class Student {
    private String id;
    private String user_name;
    private String roll_number;
    private String name;
    private Timestamp time_stamp_of_creation;
    private String password;
    private String role;

    public Student(){}

    public Student(String user_name, String roll_number, String name, String password, String role) {
        this.id = UUID.randomUUID().toString();
        this.user_name = user_name;
        this.roll_number = roll_number;
        this.name = name;
        this.password = password;
        this.role = role;
        LocalDateTime localDateTime = LocalDateTime.now();

        // Convert LocalDateTime to java.sql.Timestamp
        this.time_stamp_of_creation = Timestamp.valueOf(localDateTime);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Timestamp getTime_stamp_of_creation() {
        return time_stamp_of_creation;
    }

    public void setTime_stamp_of_creation(Timestamp time_stamp_of_creation) {
        this.time_stamp_of_creation = time_stamp_of_creation;
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
