package com.tao.wztsnn.wx.controller;

import com.tao.wztsnn.wx.entity.UserInfo;
import com.tao.wztsnn.wx.service.WxInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/wx")
public class WxInfoController {
    @Autowired
    private WxInfoService wxInfoService;

    @RequestMapping("/insertOrUpdate")
    @ResponseBody
    public Object insertOrUpdateUserInfo(@RequestBody UserInfo userInfo){
        return wxInfoService.insertOrUpdateUserInfo(userInfo);
    }

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public Object getUserInfo(String openid){
        return wxInfoService.getUserInfo(openid);
    }
}
