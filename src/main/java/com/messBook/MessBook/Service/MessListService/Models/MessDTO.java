package com.messBook.MessBook.Service.MessListService.Models;

public class MessDTO {
    public String messName;
    public String messID;
    public int messMenuItemCount;

    public MessDTO(){}

    public MessDTO(String messName, String messID, int messMenuItemCount) {
        this.messName = messName;
        this.messID = messID;
        this.messMenuItemCount = messMenuItemCount;
    }

    public String getMessName() {
        return messName;
    }

    public void setMessName(String messName) {
        this.messName = messName;
    }

    public String getMessID() {
        return messID;
    }

    public void setMessID(String messID) {
        this.messID = messID;
    }

    public int getMessMenuItemCount() {
        return messMenuItemCount;
    }

    public void setMessMenuItemCount(int messMenuItemCount) {
        this.messMenuItemCount = messMenuItemCount;
    }
}
