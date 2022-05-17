package com.xxx.foodrestaurant;

import com.xxx.foodrestaurant.controller.LeavemessageController;
import com.xxx.foodrestaurant.mapper.LeavemessageMapper;
import com.xxx.foodrestaurant.pojo.Leavemessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

@SpringBootTest
public class LeavemessageTest {
    @Autowired
    LeavemessageMapper leavemessageMapper ;
    @Test
    public void test1(){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        ArrayList<Leavemessage> queryallconments = leavemessageMapper.queryallconments();
        for (Leavemessage leavemessage : queryallconments) {
            leavemessage.setData(sdf.format(leavemessage.getProdate()));
            System.out.println(leavemessage);
        }
    }
    @Autowired
    LeavemessageController leavemessageController ;

    @Test
    public void test2(){
        String all = leavemessageController.getAll();
        System.out.println(all);
    }
    @Test
    public void test3(){
        Leavemessage leavemessage = new Leavemessage();
        leavemessage.setUsername("用户名2");
        leavemessage.setTitle("标题2");
        leavemessage.setProCon("内容3");
        leavemessageMapper.deleteLeavemessage(leavemessage);
    }

//    LeavemessageController  leavemessageController ;
    @Test
    public void test4(){
        String add = leavemessageController.add("我是名字1", "我是标题", "我是·内容");
        System.out.println(add);
    }
}
