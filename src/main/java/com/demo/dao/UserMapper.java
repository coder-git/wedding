package com.demo.dao;

import com.demo.model.User;

import java.util.List;

public interface UserMapper {

    List<User> selectAll();


    int delete(Integer userId);
    int realDelete(Integer userId);

    int insert(User record);

    User selectByPrimaryKey(Integer userId);

    int update(User record);


    User selectByAccount(String account);


    int batchInsert(List<User> userList);


    User selectByAccountAndUserId(String account, Integer userId);


    Integer updatePassword(Integer id, String password, String salt);


    int updateUserNameByUserId(String userName,Integer userId);


    List<User> selectDeletedUserList();


    int recovery(Integer id);
}