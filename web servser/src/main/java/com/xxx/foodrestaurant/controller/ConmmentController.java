package com.xxx.foodrestaurant.controller;

import com.alibaba.fastjson.JSONArray;
import com.xxx.foodrestaurant.mapper.ConmmentMapper;
import com.xxx.foodrestaurant.mapper.UserMapper;
import com.xxx.foodrestaurant.pojo.Conmment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
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


    @GetMapping("/conment/delA")
    public void delete(String title , String username){
        System.out.println(title);
        System.out.println(username);
        conmmentMapper.deleteConmment(title,username);
    }

    @GetMapping("/conment/getall")
    public String getAll(){
        List<Conmment> list = conmmentMapper.selectAll();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        for (Conmment conmment : list) {
            conmment.setData(sdf.format(conmment.getComDate()));
        }
        return JSONArray.toJSONString(list);
    }


    @GetMapping("/conment/delete")
    public String deleteConmment(String menu,String username ,String comConten){
        Conmment conmment = new Conmment();
        conmment.setMenu(menu);
        conmment.setUsername(username);
        conmment.setComConten(comConten);
        int i = conmmentMapper.deleteComments(conmment);
        if (i>0){
            return JSONArray.toJSONString(true);
        }else {
            return JSONArray.toJSONString(false);
        }
    }
    @Autowired
    UserMapper userMapper ;
    @GetMapping("/conment/commentsAll")
    public String getListBy(String menuId){
        List<Conmment> conmments = conmmentMapper.selectConmmentByMenu(menuId);
        return  JSONArray.toJSONString(conmments);
    }

    @GetMapping("/conment/add")
    public String addComment(String menuId,String username ,String comConten){
        int i = conmmentMapper.addConmment(menuId, username, comConten, new Date());
        return "";
    }




}
