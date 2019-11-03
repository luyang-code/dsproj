package com.maple.MapleMall.controller;

import com.maple.MapleMall.entity.Admin;
import com.maple.MapleMall.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
@Controller
@RequestMapping("/Login")
public class LoginController {
    @Autowired
    private IAdminService adminService;
    @Autowired
    private HttpSession httpSession;
    //登录模块
    @RequestMapping("/login")
    public ModelAndView login(String adminname, String password){
        Admin admin = new Admin();
        admin.setAdminName(adminname);
        admin.setAdminPassword(password);
        if(adminService.adminLogin(admin)){
            //登录成功
            httpSession.setAttribute("adminname",adminname);
            System.out.println("success");
            // 进入首页
            return new ModelAndView("index");
        }else{
            //登陆失败
            return new ModelAndView(new RedirectView("../login.html?status=1"));
        }
    }
}
