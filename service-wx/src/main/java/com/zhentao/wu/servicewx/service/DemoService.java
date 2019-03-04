package com.zhentao.wu.servicewx.service;

import com.zhentao.wu.automybatis.mapper.UserInfoMapper;
import com.zhentao.wu.automybatis.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.List;
import java.util.Random;

@Service
public class DemoService {
    @Autowired
    private UserInfoMapper userInfoMapper;


    public void query(){

//        Example example = new Example(UserInfo.class);
//        example.setForUpdate(true);
//        example.createCriteria().andGreaterThan("id", 100).andLessThan("id",151);
//        example.or().andLessThan("id", 41);
//        List<UserInfo> countries = userInfoMapper.selectByExample(example);

        //Example 查询
        Example exampleQuery = new Example(UserInfo.class);
        exampleQuery.createCriteria().andEqualTo("openid","oH2pc5Va8b2blOdGa7msiy-DFfxo");
        System.out.println(userInfoMapper.selectByExample(exampleQuery));


        //Example 动态
        int code = 0 ;
        code = (int)(Math.random()*100);
        Example exampleAuto = new Example(UserInfo.class);
        Example.Criteria criteria = exampleAuto.createCriteria();
        if(code >= 50){
            criteria.andLike("openid", code + "%");
        }
        if(code < 50){
            criteria.andEqualTo("openid", code);
        }
        System.out.println(userInfoMapper.selectByExample(exampleAuto));


        //更多查询的访问以下网站
        //1.https://github.com/abel533/Mapper/wiki/6.example
        //2.https://blog.csdn.net/biandous/article/details/65630783











        Weekend weekend = new Weekend(UserInfo.class);
        WeekendCriteria<UserInfo, Object> keywordCriteria = weekend.weekendCriteria();
        keywordCriteria.andEqualTo(UserInfo::getOpenid,"oH2pc5Va8b2blOdGa7msiy-DFfxo");
        System.out.println(userInfoMapper.selectByExample(weekend));


    }
}
