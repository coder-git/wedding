package com.tx.demo.webManager.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping()
@RestController
@Slf4j

public class TestZJLController {

    @GetMapping("/")
    public String Index(){
        log.warn("999{}","123");
        return "123";
    }

}
