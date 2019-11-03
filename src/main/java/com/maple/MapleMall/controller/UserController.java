package com.maple.MapleMall.controller;

import com.maple.MapleMall.entity.User;
import com.maple.MapleMall.service.IUserService;
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
@RequestMapping("/User")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private HttpSession httpSession;
    //返回全部用户的信息
    @ResponseBody
    @RequestMapping("/findAllUser")
    public List<User> getAllUser(){
        return userService.findAllUser();
    }
    //跳转会员管理页面
    @RequestMapping("/userList")
    public ModelAndView userList(){
        return new ModelAndView("userList");
    }


    //删除用户
    @ResponseBody
    @RequestMapping("/delUser/{username}")
    public boolean delUser(@PathVariable("username") String username){
        return userService.deleteUser(username);
    }

    //搜索用户
    @ResponseBody
    @RequestMapping("/findUser")
    public List<User> findUser(@RequestParam Map<String,Object> map){
        String content = (String)map.get("content");
        List<User> users = new ArrayList<>();
        if(content.equals("")){
            users = userService.findAllUser();
        }else if(isFindByNum(content)){
            users.add(userService.findUserByNum(content));
        }else{
            users.add(userService.findUserByUsername(content));
        }
        return users;
    }
    //判断是否通过编号查询
    public static boolean isFindByNum(String str) {
        if(str.charAt(0)=='U'){
            //以U开头，去除U之后为纯数字
            str=str.replace("U","");
            for (int i = 0; i < str.length(); i++) {
                if (!Character.isDigit(str.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
        //不以U开头则不是通过编号查询
        return false;
    }


    //添加用户
    @ResponseBody
    @RequestMapping("/addUserSub")
    public boolean addUserSub(@RequestParam Map<String,Object> map){
        User user = new User();
        user.setUserName((String)map.get("username"));
        user.setUserPassword((String)map.get("password"));
        return userService.addUser(user);
    }

    //提交修改
    @ResponseBody
    @RequestMapping("/changeUser")
    public boolean userInfoChangeSub(@RequestParam Map<String,Object> map){
        User user = new User();
        user.setUserName((String)map.get("username"));
        user.setUserPassword((String)map.get("password"));
//        System.out.println(user);
        return userService.updateUser(user);
    }
}
