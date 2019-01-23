package com.tao.wztsnn.wx.controller;

import com.tao.wztsnn.wx.entity.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/WxInfo")
public class WxInfoController {


    @RequestMapping("/insertOrUpdate")
    @ResponseBody
    public void insertOrUpdateUserInfo(@RequestBody UserInfo userInfo){

    }

}
