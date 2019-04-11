package com.zhentao.wu.automybatis.model;

import java.io.Serializable;
import java.util.Date;
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
    private String username;

    private String password;

    @Column(name = "register_time")
    private Date registerTime;

    private static final long serialVersionUID = 1L;
}