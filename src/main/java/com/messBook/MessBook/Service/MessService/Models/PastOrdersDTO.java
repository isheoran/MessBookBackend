package com.messBook.MessBook.Service.MessService.Models;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class PastOrdersDTO {
    private String messName;
    private List<ItemDTO>items = new ArrayList<>();
    private int netTotal = 0;
    private Timestamp dateOfOrder;
    private Timestamp dateOfResolution;

    public PastOrdersDTO(){}

    public PastOrdersDTO(String messName, List<ItemDTO> items, int netTotal, Timestamp dateOfOrder) {
        this.messName = messName;
        this.items = items;
        this.netTotal = netTotal;
        this.dateOfOrder = dateOfOrder;
    }

    public String getMessName() {
        return messName;
    }

    public void setMessName(String messName) {
        this.messName = messName;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }

    public void setItem(ItemDTO itemDTO) {
        this.items.add(itemDTO);
    }

    public int getNetTotal() {
        return netTotal;
    }

    public void setNetTotal(int netTotal) {
        this.netTotal = netTotal;
    }

    public Timestamp getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Timestamp dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public Timestamp getDateOfResolution() {
        return dateOfResolution;
    }

    public void setDateOfResolution(Timestamp dateOfResolution) {
        this.dateOfResolution = dateOfResolution;
    }
}
