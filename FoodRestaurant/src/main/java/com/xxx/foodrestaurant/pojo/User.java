package com.xxx.foodrestaurant.pojo;

public class User {
    private String username;
    private int id;
    private String password;
    private String power;
    private String head_image;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getHead_image() {
        return head_image;
    }

    public void setHead_image(String head_image) {
        this.head_image = head_image;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", id=" + id +
                ", password='" + password + '\'' +
                ", power='" + power + '\'' +
                ", head_image='" + head_image + '\'' +
                '}';
    }

    public User() {
    }

    public User(String username, int id, String password, String power, String head_image) {
        this.username = username;
        this.id = id;
        this.password = password;
        this.power = power;
        this.head_image = head_image;
    }
}
