package com.zhentao.wu.projectstart.controller;

import com.zhentao.wu.projectstart.annotation.Limit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @RequestMapping("/test")
    @Limit(name = "测试用的", key = "test", count = 0.1f)
    public @ResponseBody
    Object test() {
        return "测试ok呀";
    }
}
