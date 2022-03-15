package com.demo.modules.test.controller;

import com.demo.common.api.R;
import com.demo.common.jwt.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestDemoController {

    @Autowired
    private final JwtTokenUtils jwtTokenUtils;

    public TestDemoController(JwtTokenUtils jwtTokenUtils) {
        this.jwtTokenUtils = jwtTokenUtils;
    }


    @GetMapping("/login")
    public String login(String user, String password){
        Map map = new HashMap();
        map.put("user",user);
        map.put("password",password);


        return jwtTokenUtils.createToken(map);
    }

    @GetMapping("/getUser")
    public R getUser(){
        return R.status(true);
    }
}
