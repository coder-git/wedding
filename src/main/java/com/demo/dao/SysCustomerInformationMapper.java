package com.demo.dao;

import com.demo.model.SysCustomerInformation;

public interface SysCustomerInformationMapper {
    int deleteByPrimaryKey(Integer customerid);

    int insert(SysCustomerInformation record);

    int insertSelective(SysCustomerInformation record);

    SysCustomerInformation selectByPrimaryKey(Integer customerid);

    int updateByPrimaryKeySelective(SysCustomerInformation record);

    int updateByPrimaryKey(SysCustomerInformation record);
}