package com.xxx.foodrestaurant.pojo;

import java.util.Date;

public class Leavemessage {
    private String username;
    private String title;
    private String pro_con;
    private Date   prodate;

    @Override
    public String toString() {
        return "Leavemessage{" +
                "username='" + username + '\'' +
                ", title='" + title + '\'' +
                ", pro_con='" + pro_con + '\'' +
                ", prodate=" + prodate +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPro_con() {
        return pro_con;
    }

    public void setPro_con(String pro_con) {
        this.pro_con = pro_con;
    }

    public Date getProdate() {
        return prodate;
    }

    public void setProdate(Date prodate) {
        this.prodate = prodate;
    }

    public Leavemessage() {
    }

    public Leavemessage(String username, String title, String pro_con, Date prodate) {
        this.username = username;
        this.title = title;
        this.pro_con = pro_con;
        this.prodate = prodate;
    }
}
