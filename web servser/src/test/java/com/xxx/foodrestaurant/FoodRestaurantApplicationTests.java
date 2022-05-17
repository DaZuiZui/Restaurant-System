package com.xxx.foodrestaurant;

import com.xxx.foodrestaurant.controller.MenuController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class FoodRestaurantApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        redisTemplate.opsForHash().put("menu","菜A",1);
        redisTemplate.opsForHash().put("menu","菜B",10);
        redisTemplate.opsForHash().put("menu","菜C",9);
        redisTemplate.opsForHash().put("menu","菜E",2);
        redisTemplate.opsForHash().put("menu","菜F",200);
    }
    @Autowired
    MenuController menuController  ;

    @Test
    void queryByMenumenu(){
        System.out.println(menuController.queryByMenumenu("菜品A"));
    }
}
