package com.xxx.foodrestaurant.mapper;

import com.xxx.foodrestaurant.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
@Component
public interface UserMapper {
    /**
     * 用户登入
     * @param username
     * @param password
     * @return
     */
    @Select("select *from user where username = #{username} and password = #{password}")
    public User querytheuserbyusernameandpassword(@Param("username")String username,@Param("password")String password);

    /**
     * 注册用户
     * @param user
     */
    @Insert("insert into user values(null,#{username},#{password},'admin','null')")
    public void userReg(@RequestBody User user);

    /**
     * 删除用户 by username
     * @return
     */
    @Delete("delete from user where username = #{username}")
    public String deldeteUserByUsername(@RequestParam("username")String username);

    /**
     * 用户信息修改
     * @param user
     * @return
     */
    @Update("update user set password =#{password},head_image = #{head_image} where username #{username}")
    public String updateUserInfoByUsernamen( User user);


    /**
     * 查找了返回用户信息查不到返回null by username
     * @param username
     * @return
     */
    @Select("select *from user where username = #{username}")
    public User queryuserbyusername(@RequestParam("username")String username);


    @Select("select * from user where power!='admin'")
    public List<User> queryUserAll();

    @Update("update user set password =#{password} where username =#{username}")
    public int UpdatePassWord(String password ,String username);

    @Update("update user set head_image =#{image} where username =#{username}")
    public int UpdateImage(String username , String image) ;
}
