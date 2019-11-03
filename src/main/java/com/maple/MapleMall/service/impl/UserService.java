package com.maple.MapleMall.service.impl;

import com.maple.MapleMall.dao.IUserDao;
import com.maple.MapleMall.entity.User;
import com.maple.MapleMall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService implements IUserService {
    @Autowired
    private IUserDao userDao;


    @Override
    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    @Override
    public User findUserByNum(String num) {
        return userDao.findUserByUserNum(num);
    }

    @Override
    public boolean addUser(User user) {
        //判断用户是否存在
        if(userDao.findUserByUsername(user.getUserName())==null){
            //获取原ID
            String oldId = userDao.getMaxId();
            //去除字母
            oldId=oldId.replace("U","");
            //生成用户编号
            String newId = "U" + (Integer.parseInt(oldId) + 1);//当前最大编号值加一
            //构造用户信息
            user.setUserNum(newId);
            //信息插入数据库,返回插入结果
            return userDao.addUser(user) > 0;
        }
        return false;
    }

    @Override
    public boolean userLogin(User user) {
        User dbUser = userDao.getDBUser(user.getUserName());
        return dbUser!=null && dbUser.getUserPassword().equals(user.getUserPassword());

    }

    @Override
    public boolean updateUser(User user) {
        if(userDao.findUserByUsername(user.getUserName())!=null){
            return userDao.updateUser(user) > 0 ;
        }
        return false;
    }

    @Override
    public boolean deleteUser(String username) {
        //获取数据库对象
        User dbUser = userDao.findUserByUsername(username);
        if (dbUser!=null){
            return userDao.deleteUser(dbUser.getUserNum()) > 0;
        }
        return false;
    }

    @Override
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }
}
