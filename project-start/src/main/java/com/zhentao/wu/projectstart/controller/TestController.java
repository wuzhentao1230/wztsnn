package com.zhentao.wu.projectstart.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhentao.wu.projectstart.annotation.Result;
import com.zhentao.wu.projectstart.websocket.CustomWebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.support.CronSequenceGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

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
            // CustomWebSocket.sendInfo("测试ws成功");
            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @GetMapping("/corn/{cornStr}")
    public @ResponseBody
    Object corn(@PathVariable String cornStr) {
        List<String> results = new ArrayList<>();
        CronSequenceGenerator cronSequenceGenerator = new CronSequenceGenerator("cornStr");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<String> list = new ArrayList<>(20);
        Date nextTimePoint = new Date();
        for (int i = 0; i < 20; i++) {
            // 计算下次时间点的开始时间
            nextTimePoint = cronSequenceGenerator.next(nextTimePoint);
            list.add(sdf.format(nextTimePoint));
        }
        for (String string : list) {
            results.add(string);
        }
        return results;
    }



    @GetMapping("/httpTest")
    public @ResponseBody
    Object httpTest() {
        String url="http://www.baidu.com";
        HttpHeaders headers = new HttpHeaders();
        //定义请求参数类型，这里用json所以是MediaType.APPLICATION_JSON
        headers.setContentType(MediaType.APPLICATION_JSON);
        //RestTemplate带参传的时候要用HttpEntity<?>对象传递
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", "predictWord");
        HttpEntity<Map<String, Object>> request = new HttpEntity<Map<String, Object>>(map, headers);

        ResponseEntity<String> entity = restTemplate.postForEntity(url, request, String.class);
        //获取3方接口返回的数据通过entity.getBody();它返回的是一个字符串；
        String body = entity.getBody();
        //然后把str转换成JSON再通过getJSONObject()方法获取到里面的result对象，因为我想要的数据都在result里面
        //下面的strToJson只是一个str转JSON的一个共用方法；
        //JSONObject json = JSONObject.parseObject(body);

        return body;
    }

}
