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
@Table(name = "rm_role")
public class RmRole implements Serializable {
    /**
     * id
     */
    @Id
    private Integer id;

    /**
     * 角色
     */
    @Column(name = "role_name")
    private String roleName;

    /**
     * 备注
     */
    private String remarks;

    private static final long serialVersionUID = 1L;
}