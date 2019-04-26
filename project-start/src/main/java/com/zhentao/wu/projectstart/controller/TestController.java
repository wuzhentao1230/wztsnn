package com.zhentao.wu.projectstart.controller;

import com.zhentao.wu.projectstart.websocket.CustomWebSocket;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class TestController {

    @RequestMapping("/test")
//    @Limit(name = "测试用的", key = "test", count = 0.1f)
    public @ResponseBody
    Object test() {
        try {
            CustomWebSocket.sendInfo("测试ws成功");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }

    @GetMapping("ws")
    public String ws(){
        return "ShowLog";
    }

}
