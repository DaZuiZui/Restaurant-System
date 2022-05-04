package com.xxx.foodrestaurant.pojo;

public class Menu {
    private int id;
    private int menu_id;
    private String menu;
    private String image;
    private String flavor;
    private String introduce;
    private String menu_data;
    private String menu_make;
    private String foodtimes;
    private String menutype;

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", menu_id=" + menu_id +
                ", menu='" + menu + '\'' +
                ", image='" + image + '\'' +
                ", flavor='" + flavor + '\'' +
                ", introduce='" + introduce + '\'' +
                ", menu_data='" + menu_data + '\'' +
                ", menu_make='" + menu_make + '\'' +
                ", foodtimes='" + foodtimes + '\'' +
                ", menutype='" + menutype + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getMenu_data() {
        return menu_data;
    }

    public void setMenu_data(String menu_data) {
        this.menu_data = menu_data;
    }

    public String getMenu_make() {
        return menu_make;
    }

    public void setMenu_make(String menu_make) {
        this.menu_make = menu_make;
    }

    public String getFoodtimes() {
        return foodtimes;
    }

    public void setFoodtimes(String foodtimes) {
        this.foodtimes = foodtimes;
    }

    public String getMenutype() {
        return menutype;
    }

    public void setMenutype(String menutype) {
        this.menutype = menutype;
    }

    public Menu() {
    }

    public Menu(int id, int menu_id, String menu, String image, String flavor, String introduce, String menu_data, String menu_make, String foodtimes, String menutype) {
        this.id = id;
        this.menu_id = menu_id;
        this.menu = menu;
        this.image = image;
        this.flavor = flavor;
        this.introduce = introduce;
        this.menu_data = menu_data;
        this.menu_make = menu_make;
        this.foodtimes = foodtimes;
        this.menutype = menutype;
    }
}
