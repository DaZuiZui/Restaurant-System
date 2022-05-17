package com.xxx.foodrestaurant.mapper;

import com.xxx.foodrestaurant.pojo.Conmment;
import com.xxx.foodrestaurant.pojo.Leavemessage;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Mapper
@Component
public interface LeavemessageMapper {
    @Insert("insert into leavemessage value(#{username},#{title},#{proCon},#{prodate})")
    public int inserls(Leavemessage leavemessage);

    @Select("select *from  leavemessage")
    public ArrayList<Leavemessage> queryallconments();

    @Delete("delete from leavemessage where title = #{title} and username = #{username}")
    public void delteconment(@Param("title")String title,@Param("username")String username);

    @Delete("delete from leavemessage where username = #{username} and title =#{title} and pro_con =#{proCon} ")
    public int deleteLeavemessage(Leavemessage leavemessage) ;
}
