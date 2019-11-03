package com.maple.MapleMall.dao;

import com.maple.MapleMall.entity.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAdminDao {
    //查询当前编号最大值
    String getMaxId();
    //根据管理员名查询管理员信息
    Admin findAdminByName(String AdminName);
    //根据管理员id查询管理员信息
    Admin findAdminByNum(String AdminNum);
    //用户登录查询
    Admin getDBAdmin(String adminName);
    //获取全部管理员信息
    List<Admin> findAllAdmin();
    //增加管理员
    int addAdmin(Admin Admin);
    //根据编号删除管理员
    int deleteAdmin(String AdminNum);
    //根据管理员名修改管理员
    int updateAdmin(Admin admin);
}
