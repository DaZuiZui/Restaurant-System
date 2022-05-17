package com.xxx.foodrestaurant.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Leavemessage {
    private String username;
    private String title;
    private String proCon;
    private Date   prodate;
    private  String data;
}
