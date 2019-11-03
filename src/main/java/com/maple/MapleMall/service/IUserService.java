package com.maple.MapleMall.service;

import com.maple.MapleMall.entity.User;

import java.util.List;

public interface IUserService {
    //获取用户信息
    User findUserByUsername(String username);
    User findUserByNum(String Num);

    //注册
    boolean addUser(User user);
    //登录
    boolean userLogin(User user);
    //修改用户
    boolean updateUser(User user);
    //删除用户
    boolean deleteUser(String username);
    //获取全部用户
    List<User> findAllUser();

}
