package com.maple.MapleMall.service;

import com.maple.MapleMall.entity.Admin;

import java.util.List;

public interface IAdminService {
    //获取用户信息
    Admin findAdminByName(String adminName);
    Admin findAdminByNum(String Num);

    //注册
    boolean addAdmin(Admin admin);
    //登录
    boolean adminLogin(Admin admin);
    //修改用户
    boolean updateAdmin(Admin admin);
    //删除用户
    boolean deleteAdmin(String adminName);
    //获取全部用户
    List<Admin> findAllAdmin();
}
