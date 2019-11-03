package com.maple.MapleMall.dao;

import com.maple.MapleMall.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IUserDao {
    //查询当前编号最大值
    String getMaxId();
    //根据用户名查询用户信息
    User findUserByUsername(String userName);
    //根据用户编号查询用户信息
    User findUserByUserNum(String userNum);
    //用户登录查询
    User getDBUser(String userName);
    //获取全部用户信息
    List<User> findAllUser();
    //增加用户
    int addUser(User user);
    //根据编号删除用户
    int deleteUser(String userNum);
    //根据用户名修改用户
    int updateUser(User user);
}
