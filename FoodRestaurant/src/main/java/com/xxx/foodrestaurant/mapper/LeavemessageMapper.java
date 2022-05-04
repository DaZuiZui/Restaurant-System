package com.xxx.foodrestaurant.mapper;

import com.xxx.foodrestaurant.pojo.Conmment;
import com.xxx.foodrestaurant.pojo.Leavemessage;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface LeavemessageMapper {
    @Insert("insert into leavemessage value(#{username},#{title},#{pro_con},#{prodate})")
    public void inserls(Leavemessage leavemessage);

    @Select("select *from  leavemessage")
    public ArrayList<Leavemessage> queryallconments();

    @Delete("delete from leavemessage where title = #{title} and username = #{username}")
    public void delteconment(@Param("title")String title,@Param("username")String username);
}
