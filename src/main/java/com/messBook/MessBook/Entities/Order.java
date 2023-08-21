package com.messBook.MessBook.Entities;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

public class Order {
    private String order_id;
    private String student_id;
    private String mess_name;
    private Timestamp order_date;
    private Timestamp resolved_date;

    public Order(){}

    public Order(String student_id, String mess_name) {
        this.order_id = UUID.randomUUID().toString();
        this.student_id = student_id;

        LocalDateTime localDateTime = LocalDateTime.now();

        // Convert LocalDateTime to java.sql.Timestamp
        this.order_date = Timestamp.valueOf(localDateTime);

        this.resolved_date = null;

        this.mess_name = mess_name;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public Timestamp getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Timestamp order_date) {
        this.order_date = order_date;
    }

    public Timestamp getResolved_date() {
        return resolved_date;
    }

    public void setResolved_date(Timestamp resolved_date) {
        this.resolved_date = resolved_date;
    }

    public String getMess_name() {
        return mess_name;
    }

    public void setMess_name(String mess_name) {
        this.mess_name = mess_name;
    }
}
