package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.UserMapper;
import com.demo.model.SysAdmin;
import com.demo.model.User;
import com.demo.common.utils.HmacSHA1;
//import com.demo.common.excel.model.UserExcelModel;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public List<User> selectAll() {

        return userMapper.selectAll();
    }

    public User selectById(Integer userId) {

        return userMapper.selectByPrimaryKey(userId);
    }


    public User selectByAccount(String account) {
        return userMapper.selectByAccount(account);
    }

    public int add(User user) {

        return userMapper.insert(setUser(user));
    }

    public int batchInsert(List<User> userList) {

        return userMapper.batchInsert(userList);
    }

    public int delete(Integer userId) {

        return userMapper.delete(userId);
    }

    public int realDelete(Integer userId) {

        return userMapper.realDelete(userId);
    }

    public int update(User user) {

        return userMapper.update(setUser(user));
    }


    public int updateUserName(String userName,Integer userId) {

        return userMapper.updateUserNameByUserId(userName,userId);
    }


    private User setUser(User user) {

        user.setCreateTime(System.currentTimeMillis());
        if (user.getPassword() != null) {
            HmacSHA1 secretUtil = new HmacSHA1();
            try {
                user.setSalt(secretUtil.getSecretKey());
                user.setPassword(secretUtil.getSecretValue(user.getPassword()));
            } catch (Exception e) {

                System.out.print("密码或salt 生成失败");
                e.printStackTrace();
            }
        }
        return user;
    }

    public void save(List<User> cachedDataList) {


        for (User user : cachedDataList) {
            setUser(user);
        }
        batchInsert(cachedDataList);


    }

    public User selectByAccountAndUserId(String account, Integer userId) {
        return userMapper.selectByAccountAndUserId(account,userId);

    }


    //修改密码
    public Integer updatePassword(Integer id,String password,String salt) {

        return userMapper.updatePassword(id,password, salt);
    }

    public List<User> selectDeletedUserList() {
        return userMapper.selectDeletedUserList();
    }

    public int recovery(Integer id) {
        return userMapper.recovery(id);
    }




}
