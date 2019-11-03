package com.maple.MapleMall.service.impl;

import com.maple.MapleMall.dao.IAdminDao;
import com.maple.MapleMall.entity.Admin;
import com.maple.MapleMall.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminService implements IAdminService {
    @Autowired
    private IAdminDao adminDao;


    @Override
    public Admin findAdminByName(String adminName) {
        return adminDao.findAdminByName(adminName);
    }

    @Override
    public Admin findAdminByNum(String num) {
        return adminDao.findAdminByNum(num);
    }

    @Override
    public boolean addAdmin(Admin admin) {
        //判断用户是否存在
        if(adminDao.findAdminByName(admin.getAdminName())==null){
            //生成用户编号
            int adminId = Integer.parseInt(adminDao.getMaxId()) + 1;//当前最大编号值加一
            //构造用户信息
            admin.setAdminNum(adminId+"");
            //信息插入数据库,返回插入结果
            return adminDao.addAdmin(admin) > 0;

        }
        return false;
    }

    @Override
    public boolean adminLogin(Admin admin) {
        Admin dbAdmin = adminDao.getDBAdmin(admin.getAdminName());
        return dbAdmin!=null && dbAdmin.getAdminPassword().equals(admin.getAdminPassword());

    }

    @Override
    public boolean updateAdmin(Admin admin) {
        if(adminDao.findAdminByName(admin.getAdminName())!=null){
            return adminDao.updateAdmin(admin) > 0 ;
        }
        return false;
    }

    @Override
    public boolean deleteAdmin(String adminname) {
        //获取数据库对象
        Admin dbAdmin = adminDao.findAdminByName(adminname);
        if (dbAdmin!=null){
            return adminDao.deleteAdmin(dbAdmin.getAdminNum()) > 0;
        }
        return false;
    }

    @Override
    public List<Admin> findAllAdmin() {
        return adminDao.findAllAdmin();
    }
}
