package com.messBook.MessBook.Service.MessService.Models;

import java.sql.Timestamp;

public class OrderDTO {
    private String order_id;
    private Timestamp order_date;
    private Timestamp resolved_date;
    private String mess_name;

    public OrderDTO(){}

    public OrderDTO(String order_id, String mess_name, Timestamp order_date, Timestamp resolved_date) {
        this.order_id = order_id;
        this.order_date = order_date;
        this.resolved_date = resolved_date;
        this.mess_name = mess_name;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
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
