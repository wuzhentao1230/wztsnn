package com.zhentao.wu.automybatis.mapper;

import com.zhentao.wu.automybatis.model.TUser;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface TUserMapper extends Mapper<TUser> {
}