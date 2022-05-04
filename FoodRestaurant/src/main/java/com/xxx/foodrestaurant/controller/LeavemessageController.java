package com.xxx.foodrestaurant.controller;

import com.xxx.foodrestaurant.mapper.LeavemessageMapper;
import com.xxx.foodrestaurant.pojo.Leavemessage;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class LeavemessageController {
    @Autowired
    private LeavemessageMapper leavemessageMapper;

    @GetMapping("/insert/l")
    public String inserls(Leavemessage leavemessage){
        leavemessageMapper.inserls(leavemessage);
        return "";
    }

    /**
     * 查询全部留言
     * @return
     */
    @GetMapping("/canting/chaxunliuyan")
    public ArrayList<Leavemessage> queryallconments(){
        return leavemessageMapper.queryallconments();
    }


    /**
     * 删除浏览
     * @param title
     * @param username
     */
    @GetMapping("/canting/del")
    public void delteconment(@Param("title")String title, @Param("username")String username){
        leavemessageMapper.delteconment(title,username);
    }
}
