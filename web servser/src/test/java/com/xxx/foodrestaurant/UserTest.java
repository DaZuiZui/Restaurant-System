package com.xxx.foodrestaurant;

import com.xxx.foodrestaurant.controller.UserController;
import com.xxx.foodrestaurant.mapper.UserMapper;
import com.xxx.foodrestaurant.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserTest {
    @Autowired
    UserMapper userMapper ;

    @Test
    public void test1(){
        List<User> users = userMapper.queryUserAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Autowired
    UserController userController ;
    @Test
    public void test2(){
        System.out.println(userController.PassWordUpdate("1234", "4444"));
    }
    //updateImage
    @Test
    public void test3(){
        System.out.println(userController.updateImage("1234", "我是头像"));
    }

    @Value("${root.username}")
    String username;
    @Value("${root.password}")
    String password;
    @Test
    public void test4(){
        System.out.println(username);
        System.out.println(password);
    }

}
