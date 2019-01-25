package com.tao.wztsnn.wx.service;

import com.tao.wztsnn.wx.dao.WxInfoDao;
import com.tao.wztsnn.wx.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WxInfoService {
    @Autowired
    private WxInfoDao wxInfoDao;

    public Object insertOrUpdateUserInfo(UserInfo userInfo){
       return wxInfoDao.insertPersonInfo(userInfo);
    }

    public Object getUserInfo(String openid){
        return wxInfoDao.getUserById(openid);
    }


}
