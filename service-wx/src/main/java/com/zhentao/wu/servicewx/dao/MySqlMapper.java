package com.zhentao.wu.servicewx.dao;

import com.zhentao.wu.automybatis.model.UserInfo;
import org.apache.ibatis.annotations.Insert;

public interface MySqlMapper<T> {
    @Insert("insert into `user_info` (`openid`, `nickName`, `avatarUrl`, `city`, `country`, `province`, `gender`, `language`)" +
            "values (#{openid},#{nickName},#{avatarUrl},#{city},#{country},#{province},#{gender},#{language}) " +
            "ON DUPLICATE KEY UPDATE `avatarUrl` = #{avatarUrl}")
    public int insertPersonInfo(UserInfo userInfo);
}
