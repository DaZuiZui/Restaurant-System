package com.xxx.foodrestaurant.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.xxx.foodrestaurant.pojo.Menu;
import com.xxx.foodrestaurant.pojo.MenuType;
import com.xxx.foodrestaurant.service.MunuServer;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


@CrossOrigin
@RestController
public class MenuController {
    @Autowired
    private MunuServer munuServer;

    //获取yaml中配置的上传路径属性
    @Value(("${web.upload-path}"))
    private String uploadPath;

    /**
     * 文件下载
     * @param imgUrl
     * @return
     * @throws IOException
     */
    @GetMapping(value ="/getimage",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getPhoto(@RequestParam("imgUrl") String imgUrl) throws IOException {
        System.out.println(imgUrl);
        File file = new File(uploadPath+"/"+imgUrl);

        FileInputStream inputStream = new FileInputStream(file);

        byte[] bytes = new byte[inputStream.available()];

        inputStream.read(bytes, 0, inputStream.available());

        return bytes;
    }

    /**
     * 文件上传
     * @param file
     * @return
     */
    @PostMapping("/uploadimage")
    public String upload(@RequestPart("files") MultipartFile file){
        System.out.println("asd");
        String fileName   = file.getOriginalFilename();                    //获取文件原名
        String visibleUri = "/"+fileName;                                  //拼接访问图片的地址
        String saveUri    = uploadPath+"/"+fileName;                       //拼接保存图片的真实地址

        File saveFile = new File(saveUri);
        //判断是否存在文件夹，如果存在就返回false
        if (saveFile.exists()){
            return "false";
        }
        try {
            file.transferTo(saveFile);  //保存文件到真实存储路径下
        } catch (IOException e) {
            e.printStackTrace();
        }

        return visibleUri;
    }

    /**
     * 添加菜系
     * @param menu
     */
    @PostMapping("/insertmenu")
    public void insertMenu(@RequestBody Menu menu){
        munuServer.insertMenu(menu);
        return;
    }

    /**
     * 通过id查询指定菜系
     */
    @GetMapping("/querybymenuId")
    public String queryByMenuId(@RequestParam("id")Integer id){
        return JSONArray.toJSONString(munuServer.queryByMenuId(id));
    }

    /**
     * 修改菜谱
     */
    @PostMapping("/updateMenu")
    public void updateMenu(@RequestBody Menu menu){
        munuServer.updateMenu(menu);
        return;
    }

    /**
     * 删除菜谱
     */
    @GetMapping("/deleteMenu")
    public void deleteMenu(@RequestParam("id")Integer id){
        munuServer.deleteMenu(id);
    }

    /**
     * 插入菜谱分类
     * @param category
     * @param name
     * @return
     */
    @PostMapping("/memu/insertMenuType")
    public String insertMenuType(@RequestParam("category")String category,@RequestParam("name")String name){
        return munuServer.insertMenuType(category,name);
    }

    /**
     *   三餐推荐算法
     */
    @GetMapping("/menu/tjsfzzw")
    public String sancantuijian(){

        return munuServer.sancantuijian();
    }


    /**
     * 热门菜谱区，
     */
    @GetMapping("/menu/hotmenu")
    public String rmmenu(){
        return munuServer.rmmenu();
    }

    /**
     * 获取最新的商品
     * @return
     */
    @GetMapping("/menu/getnewgoods")
    public String newpin(){
        return munuServer.newpin();
    }

    /**
     * 获取随机口味的商品
     * @return
     */
    @GetMapping("/menu/rand")
    public ArrayList<Menu> randkouwei(){
        return munuServer.randkouwei();
    }

    /**
     * 通过menu查询指定菜系
     */
    @GetMapping("/menu/getmenubymenu")
    public Menu queryByMenumenu(@RequestParam("menu")String menu){
        return munuServer.queryByMenumenu(menu);
    }

    /**
     * 获取前三
     */
    @GetMapping("/getqiansan")
    public String qiansa(){
        return munuServer.qiansa();
    }
}
