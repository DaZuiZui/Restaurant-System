package com.xxx.foodrestaurant.mapper;

import com.xxx.foodrestaurant.pojo.Conmment;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Mapper
public interface ConmmentMapper {
    @Select("select *from comments where menu = #{menu}")
    public ArrayList<Conmment> queryallconments(@Param("menu") String menu);

    @Insert("insert into comments value(#{menu},#{username},#{com_conten},#{com_date})")
    public void insert(Conmment conmment);

    @Delete("delete from comments where menu = #{menu}")
    public void delteconment(@Param("menu")String menu);
}
