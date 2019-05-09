package com.zhentao.wu.automybatis.mapper;

import com.zhentao.wu.automybatis.model.TMenu;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TMenuMapper extends Mapper<TMenu> {
    @Select("SELECT * FROM t_user u,t_role r,t_user_role ur,t_role_menu rm,t_menu m where u.USER_ID = ur.USER_ID AND r.ROLE_ID = ur.ROLE_ID AND rm.ROLE_ID = r.ROLE_ID AND rm.MENU_ID = m.MENU_ID AND\n" +
            "u.USERNAME =  #{userName}")
    @Results({
            @Result(property = "menuId", column = "MENU_ID"),
            @Result(property = "parentId", column = "PARENT_ID"),
            @Result(property = "menuName", column = "MENU_NAME"),
            @Result(property = "path", column = "PATH"),
            @Result(property = "component", column = "COMPONENT"),
            @Result(property = "perms", column = "PERMS"),
            @Result(property = "icon", column = "ICON"),
            @Result(property = "type", column = "TYPE"),
            @Result(property = "orderNum", column = "ORDER_NUM"),
            @Result(property = "createTime", column = "CREATE_TIME"),
            @Result(property = "modifyTime", column = "MODIFY_TIME"),
    })
    public List<TMenu> findUserMenus(String userName);
}