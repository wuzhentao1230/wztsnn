package com.zhentao.wu.servicerm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class TestRightController {
//    @RequiresPermissions("user:view")
    @GetMapping
    public Object testShiro(){
        return "test good";
    }
}
