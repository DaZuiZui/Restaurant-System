package com.xxx.foodrestaurant.service;

import com.xxx.foodrestaurant.pojo.Menu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Service
public interface MunuServer {
    /**
     * 获取随机口味的
     * @return
     */
    public ArrayList<Menu> randkouwei();

    /**
     * 热门菜谱区，
     */
    public String rmmenu();

    /**
     * 获取前三
     */
    public String qiansa();

    /**
     * 通过menu查询指定菜系
     */
    @Select("select *from menu where menu = #{menu}")
    public Menu queryByMenumenu(@Param("menu")String menu);

    /**
     * 获取新商品
     * @return
     */
    public String newpin();

    /**
     *   三餐推荐算法
     */
    @GetMapping("/menu/tjsfzzw")
    public String sancantuijian();

    /**
     * 删除菜谱
     */
    @GetMapping("/deleteMenu")
    public void deleteMenu(@RequestParam("id")Integer id);

    /**
     * 修改菜谱
     * @param menu
     */
    @PostMapping("/updateMenu")
    public void updateMenu(Menu menu);

    /**
     * 通过id查询指定菜系
     */
    @GetMapping("/querybymenuId")
    public Menu queryByMenuId(@RequestParam("id")Integer id);

    /**
     * 添加菜系
     * @param menu
     */
    @PostMapping("/insertmenu")
    public void insertMenu(@RequestBody Menu menu);

    /**
     * 插入菜谱分类
     * @param category
     * @param name
     * @return
     */
    @GetMapping("/memu/insertMenuType")
    public String insertMenuType(@RequestParam("category")String category, @RequestParam("name")String name);
}
