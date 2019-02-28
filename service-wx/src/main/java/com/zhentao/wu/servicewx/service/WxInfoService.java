package com.zhentao.wu.servicewx.service;

import com.zhentao.wu.servicewx.automybatis.entity.UserInfo;
import com.zhentao.wu.servicewx.automybatis.mapper.UserInfoMapper;
import com.zhentao.wu.servicewx.dao.WxInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WxInfoService {
    @Autowired
    private WxInfoDao wxInfoDao;

    @Autowired
    private UserInfoMapper userInfoMapper;

    public Object insertOrUpdateUserInfo(UserInfo userInfo) {
        return wxInfoDao.insertPersonInfo(userInfo);
    }

    public Object getUserInfo(String openid) {
        return userInfoMapper.selectByPrimaryKey(openid);
    }

    public Object getUserInfoTest1(String openid) {
        UserInfo userInfo = new UserInfo();
        userInfo.setOpenid(openid);
        return userInfoMapper.select(userInfo
        );
    }

}
