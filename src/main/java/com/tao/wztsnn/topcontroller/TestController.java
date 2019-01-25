package com.tao.wztsnn.topcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
        @RequestMapping("/test")
    public @ResponseBody
        Object test(){
        return "test good 4";
    }
}
