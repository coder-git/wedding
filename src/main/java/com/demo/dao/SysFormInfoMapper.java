package com.demo.dao;

import com.demo.model.SysFormInfo;

public interface SysFormInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysFormInfo record);

    int insertSelective(SysFormInfo record);

    SysFormInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysFormInfo record);

    int updateByPrimaryKey(SysFormInfo record);
}