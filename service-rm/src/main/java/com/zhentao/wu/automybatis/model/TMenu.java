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
@Table(name = "t_menu")
public class TMenu implements Serializable {
    /**
     * 菜单/按钮ID
     */
    @Id
    @Column(name = "MENU_ID")
    private String menuId;

    /**
     * 上级菜单ID
     */
    @Column(name = "PARENT_ID")
    private String parentId;

    /**
     * 菜单/按钮名称
     */
    @Column(name = "MENU_NAME")
    private String menuName;

    /**
     * 对应路由path
     */
    @Column(name = "PATH")
    private String path;

    /**
     * 对应路由组件component
     */
    @Column(name = "COMPONENT")
    private String component;

    /**
     * 权限标识
     */
    @Column(name = "PERMS")
    private String perms;

    /**
     * 图标
     */
    @Column(name = "ICON")
    private String icon;

    /**
     * 类型 0菜单  1菜单子页 2按钮
     */
    @Column(name = "TYPE")
    private String type;

    /**
     * 排序 权重越大越靠上
     */
    @Column(name = "ORDER_NUM")
    private Double orderNum;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "MODIFY_TIME")
    private Date modifyTime;

    private static final long serialVersionUID = 1L;
}