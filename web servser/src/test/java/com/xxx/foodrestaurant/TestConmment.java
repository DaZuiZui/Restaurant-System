package com.xxx.foodrestaurant;

import com.xxx.foodrestaurant.controller.ConmmentController;
import com.xxx.foodrestaurant.mapper.ConmmentMapper;
import com.xxx.foodrestaurant.pojo.Conmment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.xml.ws.soap.Addressing;
import java.util.List;

@SpringBootTest
public class TestConmment {
    @Autowired
    ConmmentMapper conmmentMapper ;
    @Test
    public void test1(){
        List<Conmment> l = conmmentMapper.selectAll();
        for (Conmment conmment : l) {
            System.out.println(conmment);
        }
    }
    @Autowired
    ConmmentController conmmentController ;
    @Test
    public void test2(){
        System.out.println(conmmentController.getAll());
    }

@Autowired
private RedisTemplate redisTemplate;

    @Test
    public void test3(){
        redisTemplate.delete("menu");
    }
}
