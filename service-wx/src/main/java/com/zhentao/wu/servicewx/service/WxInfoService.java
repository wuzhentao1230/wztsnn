package com.zhentao.wu.servicewx.service;

import com.zhentao.wu.automybatis.mapper.UserInfoMapper;
import com.zhentao.wu.automybatis.model.UserInfo;
import com.zhentao.wu.servicewx.dao.WxInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.weekend.Weekend;

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

}
