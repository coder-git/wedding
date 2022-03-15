package com.demo.webManager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
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


}
