package com.zhentao.wu.servicerm.specialmapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TUserMapperS {

    @Select("SELECT role_name FROM t_user u,t_role r,t_user_role ur where u.USER_ID = ur.USER_ID AND r.ROLE_ID = ur.ROLE_ID AND u.USERNAME = #{userName}")
    public Set<String> getRoles(String userName);

    @Select("SELECT MENU_NAME,ROLE_NAME FROM t_user u,t_role r,t_user_role ur,t_role_menu rm,t_menu m where u.USER_ID = ur.USER_ID AND r.ROLE_ID = ur.ROLE_ID AND rm.ROLE_ID = r.ROLE_ID AND rm.MENU_ID = m.MENU_ID AND\n" +
            "u.USERNAME =  #{userName}")
    public Set<String> getMenu(String userName);
}
