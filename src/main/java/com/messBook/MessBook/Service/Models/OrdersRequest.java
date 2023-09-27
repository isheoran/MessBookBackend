package com.messBook.MessBook.Service.Models;

import java.util.List;

public class OrdersRequest {
    private String student_id;
    private String mess_id;
    private List<String> menuItemsIds;

    public OrdersRequest(){}

    public OrdersRequest(String student_id, String mess_id, List<String> menuItemsIds) {
        this.student_id = student_id;
        this.mess_id = mess_id;
        this.menuItemsIds = menuItemsIds;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getMess_id() {
        return mess_id;
    }

    public void setMess_id(String mess_id) {
        this.mess_id = mess_id;
    }

    public List<String> getMenuItemsIds() {
        return menuItemsIds;
    }

    public void setMenuItemsIds(List<String> menuItemsIds) {
        this.menuItemsIds = menuItemsIds;
    }
}
