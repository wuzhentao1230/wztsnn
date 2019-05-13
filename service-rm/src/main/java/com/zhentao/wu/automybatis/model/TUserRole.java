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
@Table(name = "t_user_role")
public class TUserRole implements Serializable {
    /**
     * 用户ID
     */
    @Column(name = "USER_ID")
    private String userId;

    /**
     * 角色ID
     */
    @Column(name = "ROLE_ID")
    private String roleId;

    private static final long serialVersionUID = 1L;
}