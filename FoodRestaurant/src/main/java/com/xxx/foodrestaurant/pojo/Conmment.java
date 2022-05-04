package com.xxx.foodrestaurant.pojo;


import java.util.Date;

public class Conmment {
    private String menu;
    private String username;
    private String com_conten;
    private Date com_date;

    @Override
    public String toString() {
        return "Conmment{" +
                "menu='" + menu + '\'' +
                ", username='" + username + '\'' +
                ", com_conten='" + com_conten + '\'' +
                ", com_date=" + com_date +
                '}';
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCom_conten() {
        return com_conten;
    }

    public void setCom_conten(String com_conten) {
        this.com_conten = com_conten;
    }

    public Date getCom_date() {
        return com_date;
    }

    public void setCom_date(Date com_date) {
        this.com_date = com_date;
    }

    public Conmment() {
    }

    public Conmment(String menu, String username, String com_conten, Date com_date) {
        this.menu = menu;
        this.username = username;
        this.com_conten = com_conten;
        this.com_date = com_date;
    }
}
