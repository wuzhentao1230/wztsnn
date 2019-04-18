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
@Table(name = "rm_role_permission")
public class RmRolePermission implements Serializable {
    @Id
    private Integer id;

    /**
     * 权限id
     */
    @Column(name = "permission_id")
    private Integer permissionId;

    /**
     * 角色id
     */
    @Column(name = "role_id")
    private Integer roleId;

    /**
     * 备注
     */
    private String remarks;

    private static final long serialVersionUID = 1L;
}