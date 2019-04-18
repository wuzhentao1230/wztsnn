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
@Table(name = "rm_permission")
public class RmPermission implements Serializable {
    @Id
    private Integer id;

    /**
     * 权限名
     */
    @Column(name = "permission_name")
    private String permissionName;

    /**
     * 备注
     */
    private String remarks;

    private static final long serialVersionUID = 1L;
}