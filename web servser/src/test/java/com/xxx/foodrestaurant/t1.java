package com.xxx.foodrestaurant;

import com.xxx.foodrestaurant.controller.ConmmentController;
import com.xxx.foodrestaurant.mapper.ConmmentMapper;
import com.xxx.foodrestaurant.pojo.Conmment;
import com.xxx.foodrestaurant.pojo.Menu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.List;

@SpringBootTest
public class t1 {
    @Autowired
    ConmmentMapper  conmmentMapper ;
    @Autowired
    ConmmentController conmmentController ;
    @Test
    public void test1(){
        List<Conmment> conmments = conmmentMapper.selectConmmentByMenu("9");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        for (Conmment menu : conmments) {
            menu.setData(sdf.format(menu.getComDate()));
            System.out.println(menu);
        }
    }

    @Test
    public void test2(){

        String s = conmmentController.addComment("9", "1234", "我是正文");

    }
}
