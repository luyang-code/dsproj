package com.maple.MapleMall.controller;

import com.maple.MapleMall.entity.Admin;
import com.maple.MapleMall.service.IAdminService;
import com.maple.MapleMall.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Admin")
public class AdminController {
    @Autowired
    private IAdminService adminService;
    @Autowired
    private HttpSession httpSession;


    //注销登录
    @RequestMapping("/logout")
    public String logout(){
        httpSession.invalidate();
        return "redirect:/login.html";
    }

    //返回全部用户的信息
    @ResponseBody
    @RequestMapping("/findAllAdmin")
    public List<Admin> getAllAdmin(){
        return adminService.findAllAdmin();
    }
    //跳转到管理页面
    @RequestMapping("/adminList")
    public ModelAndView adminList(){
        return new ModelAndView("adminList");
    }


    //删除用户
    @ResponseBody
    @RequestMapping("/delAdmin/{adminname}")
    public boolean delAdmin(@PathVariable("adminname") String adminname){
        return adminService.deleteAdmin(adminname);
    }

    //搜索用户
    @ResponseBody
    @RequestMapping("/findAdmin")
    public List<Admin> findAdmin(@RequestParam Map<String,Object> map){
        String content = (String)map.get("content");
        List<Admin> admins = new ArrayList<>();
        if(content.equals("")){
            admins = adminService.findAllAdmin();
        }else if(isNumber(content)){
            admins.add(adminService.findAdminByNum(content));
        }else{
            admins.add(adminService.findAdminByName(content));
        }
        return admins;
    }
    //判断是否通过编号查询
    public static boolean isNumber(String str) {

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    //添加新用户跳转
    @RequestMapping("/addAdmin")
    public ModelAndView addAdmin(){
        return new ModelAndView("addAdmin");
    }

    //添加用户
    @ResponseBody
    @RequestMapping("/addAdminSub")
    public boolean addAdminSub(@RequestParam Map<String,Object> map){
        Admin admin = new Admin();
        admin.setAdminName((String)map.get("adminname"));
        admin.setAdminPassword((String)map.get("password"));
        return adminService.addAdmin(admin);
    }

    //提交修改
    @ResponseBody
    @RequestMapping("/changeAdmin")
    public boolean adminInfoChangeSub(@RequestParam Map<String,Object> map){
        Admin admin = new Admin();
        admin.setAdminName((String)map.get("adminname"));
        admin.setAdminPassword((String)map.get("password"));
//        System.out.println(admin);
        return adminService.updateAdmin(admin);
    }
}
