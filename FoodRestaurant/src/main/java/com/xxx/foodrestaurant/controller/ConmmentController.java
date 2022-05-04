package com.xxx.foodrestaurant.controller;

import com.xxx.foodrestaurant.mapper.ConmmentMapper;
import com.xxx.foodrestaurant.pojo.Conmment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

@RestController
public class ConmmentController {
    @Autowired
    private ConmmentMapper conmmentMapper;

    /**
     * 获取指定菜谱的数据
     * @param menu
     * @return
     */
    @GetMapping("/getconmmentbymenu")
    public ArrayList<Conmment> queryallconments(@Param("menu") String menu){
        return conmmentMapper.queryallconments(menu);
    }


    /**
     * 插入评论
     * @param conmment
     */
    @PostMapping("/comment/insert")
    public void insert(Conmment conmment){
        conmment.setCom_date(new Date());
        conmmentMapper.insert(conmment);
        return;
    }

    /**
     * 删除评论
     * @param menu
     */
    @GetMapping("/conment/del")
    public void delteconment(@RequestParam("menu")String menu){
        conmmentMapper.delteconment(menu);
    }

}
