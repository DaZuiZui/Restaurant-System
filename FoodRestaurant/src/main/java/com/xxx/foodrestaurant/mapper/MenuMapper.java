package com.xxx.foodrestaurant.mapper;

import com.xxx.foodrestaurant.pojo.Menu;
import com.xxx.foodrestaurant.pojo.MenuType;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface MenuMapper {
    @Select("SELECT * FROM menu ORDER BY RAND() LIMIT 5")
    public ArrayList<Menu> randkouwei();

    @Select("SELECT *,count(menutype) as count from menu GROUP BY menutype HAVING count(menutype) >= 1 order by count desc")
    public ArrayList<Menu> rmmenuorder();

    @Select("SELECT *from menu ORDER BY menu_id desc limit 5")
    public ArrayList<Menu> querynew();

    @Update("update menu set menu = #{menu},image = #{image},flavor=#{flavor},introduce=#{introduce},menu_data=#{menu_data},menu_make=#{menu_make},foodtimes=#{foodtimes},menutype=#{menutype} where id = #{id}")
    public void updateMenu(Menu menu);

    @Insert("insert into menu_type values(#{category},#{name})")
    public void insertMenuType(MenuType menuType);

    @Select("select *from menu_type")
    public List<MenuType> getalldata();

    /**
     * 添加菜系
     * @param menuType
     */
    @Insert("insert into menu values(null,#{menu},#{image},#{flavor},#{introduce},#{menu_data},#{menu_make},#{foodtimes},#{menutype})")
    public void insertMenu(@RequestBody Menu menuType);

    /**
     * 通过id查询指定菜系
     */
    @Select("select *from menu where menu_id = #{menu_id}")
    public Menu queryByMenuId(@Param("menu_id")Integer id);

    /**
     * 通过id查询指定菜系
     */
    @Select("select *from menu where menu = #{menu}")
    public Menu queryByMenumenu(@Param("menu")String menu);

    /**
     * 删除菜谱
     */
    @Delete("delete from menu where id ")
    public void deleteMenu(@RequestParam("id")Integer id);

    @Select("select *from menu where foodtimes = #{foodtimes}")
    public ArrayList<Menu> selectalldatasacan(@Param("foodtimes")String foodtimes);
}
