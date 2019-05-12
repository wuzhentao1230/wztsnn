package com.zhentao.wu.servicerm.service.impl;

import com.zhentao.wu.automybatis.mapper.TMenuMapper;
import com.zhentao.wu.automybatis.model.TMenu;
import com.zhentao.wu.servicerm.domain.router.RouterMeta;
import com.zhentao.wu.servicerm.domain.router.VueRouter;
import com.zhentao.wu.servicerm.service.MenuService;
import com.zhentao.wu.servicerm.util.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceIml implements MenuService {
    @Autowired
    private TMenuMapper tMenuMapper;

    @Override
    public ArrayList<VueRouter<TMenu>> getUserRouters(String username) {
        List<VueRouter<TMenu>> routes = new ArrayList<>();
        List<TMenu> menus = this.tMenuMapper.findUserMenus(username);
        menus.forEach(menu -> {
            VueRouter<TMenu> route = new VueRouter<>();
            route.setId(menu.getMenuId().toString());
            route.setParentId(menu.getParentId().toString());
            route.setIcon(menu.getIcon());
            route.setPath(menu.getPath());
            route.setComponent(menu.getComponent());
            route.setType(menu.getType());
            route.setName(menu.getMenuName());
            route.setMeta(new RouterMeta(true, null));
            routes.add(route);
        });
        return TreeUtil.buildVueRouter(routes);
    }
}
