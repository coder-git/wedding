package com.demo.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.UserService;
import com.demo.common.api.R;
import com.demo.model.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


@Api(tags="销售用户管理")
@RequestMapping("admin/user")
@RestController
public class UserController {


    @Autowired
    UserService userService;

    @ApiOperation("查询")
    @GetMapping(path="select",params="id")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id", value="用户id",required =  true,dataTypeClass=Integer.class)
    })
    public R<User> select(@Valid @RequestParam Integer id) {

        User u = userService.selectById(id);
        return  R.data(u);

    }



    @ApiOperation("查询")
    @GetMapping(path="select")
    public R<List<User>> selectAll() {

        List<User> u = userService.selectAll();
        return  R.data(u);
    }



    @ApiOperation("销售账号回收站-查询已删除用户")
    @GetMapping(path="selectDeletedUserList")
    public R<List<User>> selectDeletedUser() {

        List<User> uList = userService.selectDeletedUserList();
        return   R.data(uList);
    }




    @ApiOperation("删除")
    @PostMapping(path="delete")
    @ApiImplicitParams({
            @ApiImplicitParam(name="map", value="id",required =  true,dataTypeClass=Map.class)
    })
    public R<String> delete(@Valid @RequestBody Map<String,Integer> map) {
        Integer id = map.get("id");
        if(id == null  || id < 1) return   R.data(null,"参数不正确");
        int i  = userService.delete(id);
        return i == 1 ?  new ResultData<>(true)  : new ResultData<>(false);
    }


    @ApiOperation("销售账号回收站-还原")
    @PostMapping(path="recovery")
    @ApiImplicitParams({
            @ApiImplicitParam(name="map", value="id",required =  true,dataTypeClass=Map.class)
    })
    public ResultData<String> update(@Valid @RequestBody Map<String,Integer> map) {

        Integer id = map.get("id");
        if(id == null  || id < 1) return new ResultData<>(false);

        int i = userService.recovery(id);
        return i == 1? new ResultData<>(true,"修改成功") : new ResultData<>(false,"修改失败");
    }


    @ApiOperation("销售账号回收站-真实删除")
    @PostMapping(path="realDelete")
    @ApiImplicitParams({
            @ApiImplicitParam(name="map", value="id",required =  true,dataTypeClass=Map.class)
    })
    public ResultData<String> realDelete(@Valid @RequestBody Map<String,Integer> map) {
        Integer id = map.get("id");
        if(id == null  || id < 1) return new ResultData<>(false);
        int i  = userService.realDelete(id);
        return i == 1 ?  new ResultData<>(true)  : new ResultData<>(false);
    }


    @ApiOperation("添加")
    @PostMapping(path="add")
    @ApiImplicitParams({
            @ApiImplicitParam(name="user", value="用户信息",required =  true,dataTypeClass=User.class)
    })
    public ResultData<String> add(@Valid @RequestBody User user) {


        if(StringUtils.isBlank(user.getPassword())) {return new ResultData<>(false,"密码不能为空");}
        if(null != userService.selectByAccount(user.getAccount())) {
            return new ResultData<>(false,"账号已存在");
        }
        int i = userService.add(user);

        return i == 1? new ResultData<>(true,"添加成功") : new ResultData<>(false,"添加失败");

    }


    @ApiOperation("修改")
    @PostMapping(path="update")
    @ApiImplicitParams({
            @ApiImplicitParam(name="user", value="用户信息",required =  true,dataTypeClass=User.class)
    })
    public ResultData<String> update(@Valid @RequestBody User user) {
        if(StringUtils.isBlank(user.getPassword())) user.setPassword(null);


        User repeatUser =  userService.selectByAccountAndUserId(user.getAccount(),user.getUserId());
        if(null != repeatUser ) {
            return new ResultData<>(false,"账号已存在");
        }

        int i = userService.update(user);
        return i == 1? new ResultData<>(true,"修改成功") : new ResultData<>(false,"修改失败");
    }


}
