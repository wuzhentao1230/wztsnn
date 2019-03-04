package com.zhentao.wu.automybatis.model;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@Accessors(chain = true)
@Table(name = "user_info")
public class UserInfo implements Serializable {
    @Id
    private String openid;

    @Column(name = "nickName")
    private String nickname;

    @Column(name = "avatarUrl")
    private String avatarurl;

    private String city;

    private String country;

    private String province;

    private Byte gender;

    private String language;

    private static final long serialVersionUID = 1L;
}