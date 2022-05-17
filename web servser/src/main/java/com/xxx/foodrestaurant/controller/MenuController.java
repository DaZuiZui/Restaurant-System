package com.xxx.foodrestaurant.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.xxx.foodrestaurant.mapper.MenuMapper;
import com.xxx.foodrestaurant.pojo.Menu;
import com.xxx.foodrestaurant.pojo.MenuType;
import com.xxx.foodrestaurant.service.MunuServer;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.*;


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
    public String insertMenu(@RequestBody Menu menu){

        String url = menu.getImage();
        System.out.println(url);
        menu.setImage("http://127.0.0.1:8989/getimage?imgUrl="+url);
        try {
            munuServer.insertMenu(menu);
            return JSONArray.toJSONString(true);
        }catch (Exception e){
            e.printStackTrace();
            return JSONArray.toJSONString(false);
        }
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
    public String queryByMenumenu(@RequestParam("menu")String menu){
        return munuServer.queryByMenumenu(menu);
    }

    /**
     * 获取前三
     */
    @GetMapping("/getqiansan")
    public String qiansa(){
        return munuServer.qiansa();
    }


    /**
     * 筛选查找
     * @param menu
     * @return
     */
    @GetMapping("/menu/fenzu")
    public ArrayList<Menu> selectdata(Menu menu){
        System.out.println(menu);
        return munuServer.selectdata(menu);
    }
    @GetMapping("/menu/getAll")
    public String getAll(){
        return munuServer.getALL();
    }
    @Resource

    MenuMapper menuMapper ;
    @GetMapping("/menu/alltype")
    public String type(){
        List<Menu> menus = menuMapper.selectALL();
        Set<String> tyoe = new HashSet<>();
        for (Menu menu : menus) {
//            String menutype =
            tyoe.add( menu.getMenutype());
        }
        return JSONArray.toJSONString(tyoe);
    }

    @GetMapping("/menu/querybytype")
    public String querybytype(String flavor,String menuMake,String menuType){
        if (flavor.length() == 0) {
            flavor = null;
        }
        if (menuMake.length() == 0) {
            menuMake = null;
        }
        if (menuType.length() == 0) {
            menuType = null;
        }
        Menu menu = new Menu();
        menu.setFlavor(flavor);
        menu.setMenuMake(menuMake);
        menu.setMenutype(menuType);
        System.out.println(menu);
        ArrayList<Menu> selectdata = menuMapper.selectdata(menu);
        String s = JSONArray.toJSONString(selectdata);
        System.out.println(s);
        return s ;
    }



}
