package com.xxx.foodrestaurant.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    private int id;
    private int menuId;
    private String menu;
    private String image;
    private String flavor;
    private String introduce;
    private String menuData;
    private String menuMake;
    private String menutype ;
    private String foodtimes;
}
