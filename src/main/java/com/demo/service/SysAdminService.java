package com.demo.service;


import com.demo.dao.SysAdminMapper;
import com.demo.model.SysAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SysAdminService {


    @Autowired
    SysAdminMapper sysAdminMapper;

    public SysAdmin getAdmin(String systemAccount) {
        return sysAdminMapper.selectByAccount(systemAccount);
    }


    public Integer updatePassword(Integer id,String password,String salt) {
//        return sysAdminMapper.updatePassword(id,password, salt);
        return null;
    }

}


