package com.xxx.foodrestaurant.pojo;

public class MenuType {
    private String category;
    private String name;

    @Override
    public String toString() {
        return "MenuType{" +
                "category='" + category + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MenuType() {
    }

    public MenuType(String category, String name) {
        this.category = category;
        this.name = name;
    }
}
