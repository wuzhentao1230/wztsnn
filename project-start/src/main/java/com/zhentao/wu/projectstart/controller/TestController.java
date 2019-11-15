package com.zhentao.wu.projectstart.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhentao.wu.projectstart.annotation.Result;
import com.zhentao.wu.projectstart.websocket.CustomWebSocket;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class TestController {

    @RequestMapping("/test")
//    @Limit(name = "测试用的", key = "test", count = 0.1f)
//    @Result
    public @ResponseBody
    Object test(String predictWord) {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code",0);
            jsonObject.put("type","success");


            JSONObject dd1 = new JSONObject();
            dd1.put("label","吴振涛");
            dd1.put("value","1");
            JSONObject dd2 = new JSONObject();
            dd2.put("label","史楠楠");
            dd2.put("value","2");

            JSONArray jsonArray = new JSONArray();
            jsonArray.add(dd1);
            jsonArray.add(dd2);




            jsonObject.put("content",jsonArray);
//            CustomWebSocket.sendInfo("测试ws成功");
            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    @GetMapping("ws")
//    public String ws(){
//        return "ShowLog";
//    }

}
