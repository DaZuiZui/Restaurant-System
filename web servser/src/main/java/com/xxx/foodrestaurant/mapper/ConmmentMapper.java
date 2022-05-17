package com.xxx.foodrestaurant.mapper;

import com.xxx.foodrestaurant.pojo.Conmment;
import com.xxx.foodrestaurant.pojo.Menu;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Mapper
@Component
public interface ConmmentMapper {
    @Select("select *from comments where menu = #{menu}")
    public ArrayList<Conmment> queryallconments(@Param("menu") String menu);

    @Insert("insert into comments value(#{menu},#{username},#{com_conten},#{com_date})")
    public int insert(Conmment conmment);

    @Delete("delete from comments where menu = #{menu}")
    public void delteconment(@Param("menu")String menu);

    @Delete("delete from comments where title = #{title} and username = #{username}")
    public void deleteConmment(String title , String username) ;

    @Select("select * from comments")
    public List<Conmment> selectAll() ;

//    @Delete("")
    @Delete("delete from comments where menu = #{menu} and username=#{username} and com_conten =#{comConten}")
    public int deleteComments(Conmment conmment) ;

    @Select("select * from comments where menu =#{menu}")
    public List<Conmment> selectConmmentByMenu(String menu) ;

    @Insert("insert into comments  value(#{menu},#{username},#{comConten},#{comDate})")
    public int addConmment(String menu , String username , String comConten , Date comDate);

}
