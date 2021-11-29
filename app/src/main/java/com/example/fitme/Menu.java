package com.example.fitme;

public class Menu {
    String time,menu;

    public Menu(String time, String menu) {
        this.time = time;
        this.menu = menu;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }
}


