package com.xxx.foodrestaurant.controller;

import com.xxx.foodrestaurant.mapper.UserMapper;
import com.xxx.foodrestaurant.pojo.User;
import com.xxx.foodrestaurant.service.UserServer;
import com.xxx.foodrestaurant.service.impl.UserServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserServerImpl userServer;

    /**
     *需要传入username，如果信息信息错误就返回error ，如果删除成功返回true
     * @return
     */
    @PostMapping("/user/del")
    public String deldeteUserByUsername(@RequestParam("username")String username){

        return userServer.deldeteUserByUsername(username);
    }

    /**
     *需要提供用户的Entry，对用户的信息进行修改
     * @param user
     * @return
     */
    @PostMapping("/user/update")
    public String updateUserInfoByUsernamen(@RequestBody User user){
        return userServer.updateUserInfoByUsernamen(user);
    }

    /**
     * 需要传入username 和password，如果信息错误返回error 登入成功返回true 失败返回false
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/user/login")
    public String userLogin(@RequestParam("username")String username,@RequestParam("password")String password){
        return userServer.userLogin(username, password);
    }

    /**
     *提供用户的实体类，注册成功返回true，注册失败返回false，信息错误返回error
     * @param user
     * @return
     */
    @PostMapping("/user/reg")
    public String userReg(@RequestBody User user){
       return userServer.userReg(user);
    }

    /**
     * 查找了返回用户信息查不到返回null by username
     * @param username
     * @return
     */
    @GetMapping("/user/querytheuserbyusername")
    public String queryuserbyusername(@RequestParam("username")String username){
        return userServer.queryuserbyusername(username);
    }
}
