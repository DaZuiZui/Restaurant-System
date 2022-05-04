package com.xxx.foodrestaurant.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.xxx.foodrestaurant.mapper.MenuMapper;
import com.xxx.foodrestaurant.pojo.Menu;
import com.xxx.foodrestaurant.pojo.MenuType;
import com.xxx.foodrestaurant.service.MunuServer;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class MunuServerImpl implements MunuServer {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 获取前三
     */
    public String qiansa(){
        Set<String> s = redisTemplate.opsForHash().keys("menu");
        ArrayList<Menu> arrayList = new ArrayList<>();

        for (String s1 : s) {
            Menu menu = new Menu();
            menu.setId((Integer) redisTemplate.opsForHash().get("menu",s1));
            menu.setMenu(s1);
            arrayList.add(menu);
        }
        Collections.sort(arrayList, new Comparator<Menu>() {
            @Override
            public int compare(Menu o1, Menu o2) {
                if (o1.getId() > o2.getId()) {
                    return 1;
                }
                if (o1.getId()  == o2.getId() ) {
                    return 0;
                }
                return -1;
            }
        });

        if (arrayList.size() <3 ){
            return JSONArray.toJSONString(arrayList);
        }
        ArrayList<Menu> arrayList1 = new ArrayList();
        arrayList1.add(arrayList.get(arrayList.size()-1));
        arrayList1.add(arrayList.get(arrayList.size()-2));
        arrayList1.add(arrayList.get(arrayList.size()-3));
        return JSONArray.toJSONString(arrayList1);
    }


    /**
     * 通过menu查询指定菜系
     */
    @Override
    public Menu queryByMenumenu(String menu){
        Menu menu1 = menuMapper.queryByMenumenu(menu);
        Integer integer = (Integer) redisTemplate.opsForHash().get("menu",menu);
        if (integer == 0 || integer == null){
            redisTemplate.opsForHash().put("menu",menu,1);
        }else{
            redisTemplate.opsForHash().put("menu",menu,1+integer);
        }

        return menu1;
    }

    /**
     * 获取随机口味的
     * @return
     */
    @Override
    public ArrayList<Menu> randkouwei(){
        return menuMapper.randkouwei();
    }

    /**
     * 获取新品
     * @return
     */
    @Override
    public String newpin(){
        ArrayList<Menu> querynew = menuMapper.querynew();
        return JSONArray.toJSONString(querynew);
    }

    /**
     * 热门菜谱区，
     */
    public String rmmenu(){
        //获取热门菜谱分类
        ArrayList<Menu> rmmenuorder = menuMapper.rmmenuorder();
        return JSONArray.toJSONString(rmmenuorder);
    }

    /**
     * 三餐推荐算法
     * @return
     */
    @Override
    public String sancantuijian() {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("HH");
        String str = df.format(date);
        int a = Integer.parseInt(str);
        ArrayList<Menu> res = new ArrayList<>();
        if (a >= 0 && a <= 12) {
            res = menuMapper.selectalldatasacan("早");
        }
        if (a > 12 && a <= 13) {
            res = menuMapper.selectalldatasacan("中");
        }
        if (a > 13 && a <= 24) {
            res = menuMapper.selectalldatasacan("晚");
        }

        return JSONArray.toJSONString(res);
    }

    /**
     * 删除菜谱
     */
    @GetMapping("/deleteMenu")
    public void deleteMenu(@RequestParam("id")Integer id){
        menuMapper.deleteMenu(id);
    }

    /**
     * 修改菜谱
     * @param menu
     */
    @Override
    public void updateMenu(Menu menu){
        menuMapper.updateMenu(menu);
    }

    /**
     * 通过id查询指定菜系
     */
    @Override
    public Menu queryByMenuId(@RequestParam("id")Integer id){
        return menuMapper.queryByMenuId(id);
    }

    /**
     * 添加菜系
     * @param menu
     */
    @PostMapping("/insertmenu")
    public void insertMenu(@RequestBody Menu menu){
        menuMapper.insertMenu(menu);
    }

    /**
     * 插入菜谱分类
     * @param category
     * @param name
     * @return
     */
    @Override
    public String insertMenuType(@RequestParam("category")String category, @RequestParam("name")String name){
        menuMapper.insertMenuType(new MenuType(category,name));
        return "true";
    }
}
