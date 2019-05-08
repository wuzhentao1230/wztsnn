package com.zhentao.wu.servicerm.service;

import com.zhentao.wu.automybatis.model.TMenu;
import com.zhentao.wu.servicerm.domain.router.VueRouter;

import java.util.ArrayList;

public interface MenuService {

    /**
     * 通过用户名构建 Vue路由
     *
     * @param username 用户名
     * @return 路由集合
     */
    public ArrayList<VueRouter<TMenu>> getUserRouters(String username);
}
