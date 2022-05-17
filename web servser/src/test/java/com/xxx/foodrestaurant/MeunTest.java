package com.xxx.foodrestaurant;

import com.xxx.foodrestaurant.controller.MenuController;
import com.xxx.foodrestaurant.mapper.MenuMapper;
import com.xxx.foodrestaurant.pojo.Menu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
@SpringBootTest
public class MeunTest {

    @Resource
    MenuMapper menuMapper ;
    @Resource
    MenuController menuController ;
    @Test
    public void test1(){
        Menu menu = new Menu();

        String querybytype = menuController.querybytype(null, null, "川菜");
        System.out.println(querybytype);
    }

}
