package com.xxx.foodrestaurant.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.xxx.foodrestaurant.mapper.UserMapper;
import com.xxx.foodrestaurant.pojo.User;
import com.xxx.foodrestaurant.service.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class UserServerImpl implements UserServer {
    @Autowired
    private UserMapper userMapper;

    /**
     *需要传入username，如果信息信息错误就返回error ，如果删除成功返回true
     * @return
     */
    @Override
    public String deldeteUserByUsername(@RequestParam("username")String username){
        if (username != null){
            userMapper.deldeteUserByUsername(username);
            return "true";
        }
        return "error";
    }

    /**
     *需要提供用户的Entry，对用户的信息进行修改
     * @param user
     * @return
     */
    @Override
    public String updateUserInfoByUsernamen(@RequestBody User user){
        if (user != null){
            userMapper.updateUserInfoByUsernamen(user);
            return "true";
        }

        return "error";
    }

    /**
     * 需要传入username 和password，如果信息错误返回error 登入成功返回true 失败返回false
     * @param username
     * @param password
     * @return
     */
    @Override
    public String userLogin(@RequestParam("username")String username,@RequestParam("password")String password){
        if (username != null && password !=null){
            User user = userMapper.querytheuserbyusernameandpassword(username, password);
            if (user == null){
                return "false";
            }else{
                return JSONArray.toJSONString(user);
            }
        }

        return "error";
    }

    /**
     * 需要传入username 和password，如果信息错误返回error 登入成功返回true 失败返回false
     * @param username
     * @param password
     * @return
     */
    @Override
    public String adminLogin(@RequestParam("username")String username,@RequestParam("password")String password){
        if (username != null && password !=null){
            User user = userMapper.querytheuserbyusernameandpassword(username, password);
            if (user == null){
                return "false";
            }else{
                if (user.getPower().equals("admin")){
                    return "true";
                }
                return "false";
            }
        }

        return "error";
    }

    /**
     *提供用户的实体类，注册成功返回true，注册失败返回false，信息错误返回error
     * @param user
     * @return
     */
    @Override
    public String userReg(@RequestBody User user){
        if (user != null){
            //查看是否被注册了
            User user1 = userMapper.queryuserbyusername(user.getUsername());
            if (user1 == null){
                userMapper.userReg(user);
                return "true";
            }else{
                return "false";
            }
        }

        return "error";
    }

    /**
     * 查找了返回用户信息查不到返回null by username xin息错误返回error
     * @param username
     * @return
     */
    @Override
    public String queryuserbyusername(@RequestParam("username")String username){
        if (username != null){
            User user = userMapper.queryuserbyusername(username);
            return JSONArray.toJSONString(user);
        }

        return "error";
    }


    public String QueryUserAll(){
        List<User> users = userMapper.queryUserAll();
       return JSONArray.toJSONString(users);
    }
}
