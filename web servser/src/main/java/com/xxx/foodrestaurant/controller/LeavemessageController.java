package com.xxx.foodrestaurant.controller;

import com.alibaba.fastjson.JSONArray;
import com.xxx.foodrestaurant.mapper.LeavemessageMapper;
import com.xxx.foodrestaurant.pojo.Leavemessage;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@RestController
@CrossOrigin

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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        ArrayList<Leavemessage> queryallconments = leavemessageMapper.queryallconments();
        for (Leavemessage leavemessage : queryallconments) {
            leavemessage.setData(sdf.format(leavemessage.getProdate()));
        }
        return queryallconments;
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

    @GetMapping("/leavemessage/getAll")
   public String  getAll(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        ArrayList<Leavemessage> queryallconments = leavemessageMapper.queryallconments();
        for (Leavemessage leavemessage : queryallconments) {
            leavemessage.setData(sdf.format(leavemessage.getProdate()));
        }
         return JSONArray.toJSONString(queryallconments);
   }

    @GetMapping("/leavemessage/del")
   public String delete(String username ,String title ,String procon){
        Leavemessage leavemessage = new Leavemessage();
        leavemessage.setUsername(username);
        leavemessage.setTitle(title);
        leavemessage.setProCon(procon);
        System.out.println(leavemessage);
        int i = leavemessageMapper.deleteLeavemessage(leavemessage);
        if (i > 0 ){
            return JSONArray.toJSONString(true);
        }else {
            return JSONArray.toJSONString(false);
        }
    }
    @GetMapping("/leavemessage/add")
    public String add(String username,String title,String proCon){
        Leavemessage leavemessage = new Leavemessage();
        leavemessage.setUsername(username);
        leavemessage.setTitle(title);
        leavemessage.setProCon(proCon);
        leavemessage.setProdate(new Date());
        if (leavemessageMapper.inserls(leavemessage) >0) {
            return JSONArray.toJSONString(true);
        }else {
            return JSONArray.toJSONString(false);
        }
    }
}
