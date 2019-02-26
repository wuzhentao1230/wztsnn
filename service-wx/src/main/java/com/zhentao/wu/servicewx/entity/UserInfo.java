package com.zhentao.wu.servicewx.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfo {
    private String openid;
    private String nickName;
    private String avatarUrl;
    private String city;
    private String country;
    private String province;
    private String language;
    private int gender;
}
