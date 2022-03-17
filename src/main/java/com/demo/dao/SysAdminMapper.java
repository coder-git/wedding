package com.demo.dao;

import com.demo.model.SysAdmin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysAdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysAdmin record);

    int insertSelective(SysAdmin record);

    SysAdmin selectByPrimaryKey(Integer id);

    SysAdmin selectByAccount(String systemAccount);

    int updateByPrimaryKeySelective(SysAdmin record);

    int updateByPrimaryKey(SysAdmin record);
}