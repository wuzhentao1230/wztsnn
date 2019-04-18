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
@Table(name = "rm_user")
public class RmUser implements Serializable {
    /**
     * 用户id
     */
    @Id
    private Integer id;

    /**
     * 用户账号
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 备注
     */
    private String remarks;

    private static final long serialVersionUID = 1L;
}