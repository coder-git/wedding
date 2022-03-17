package com.demo.webManager.controller;

import com.demo.common.api.R;
import com.demo.model.SysAdmin;
import com.demo.model.SysUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Api(tags="后台首页")
@RequestMapping("/admin/")
public class AdminIndexController {



    @ApiOperation("测试查询")
    @GetMapping(path="selectCategory")
    public String Index(){
        log.warn("999{}","123");
        return "123";
    }

    @ApiOperation("根据用户名查询管理员")
    @GetMapping(path="getAdmin")
    public R<SysAdmin> getAdmin(String systemAccount) {

        SysAdmin sysAdmin = new SysAdmin(1,"adminAccount","adminPassword","salt");

        return R.data(sysAdmin,"123");
    }


    @ApiOperation("添加管理员")
    @PostMapping(path="addAdmin")
    public R<String> addAdmin(SysAdmin sysAdmin){

        return null;
    }



}
