package com.zhentao.wu.projectstart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
        @RequestMapping("/test")
    public @ResponseBody
        Object test(){
        return "ThreadPoolExecutor good 4";
    }
}
