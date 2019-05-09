package com.zhentao.wu.servicerm.util;


import com.zhentao.wu.servicerm.domain.router.RouterMeta;
import com.zhentao.wu.servicerm.domain.router.VueRouter;

import java.util.ArrayList;
import java.util.List;

public class TreeUtil {

    protected TreeUtil() {

    }

    private final static String TOP_NODE_ID = "0";


    /**
     * 构造前端路由
     *
     * @param routes routes
     * @param <T>    T
     * @return ArrayList<VueRouter<T>>
     */
    public static <T> ArrayList<VueRouter<T>> buildVueRouter(List<VueRouter<T>> routes) {
        if (routes == null) {
            return null;
        }
        List<VueRouter<T>> topRoutes = new ArrayList<>();
        VueRouter<T> router = new VueRouter<>();
        router.setName("系统主页");
        router.setPath("/home");
        router.setComponent("HomePageView");
        router.setIcon("home");
        router.setChildren(null);
        router.setMeta(new RouterMeta(false, true));
        topRoutes.add(router);

        routes.forEach(route -> {
            String parentId = route.getParentId();
            if (parentId == null || TOP_NODE_ID.equals(parentId)) {
                topRoutes.add(route);
                return;
            }
            for (VueRouter<T> parent : routes) {
                String id = parent.getId();
                if (id != null && id.equals(parentId)) {
                    if (parent.getChildren() == null)
                        parent.initChildren();
                    parent.getChildren().add(route);
                    parent.setHasChildren(true);
                    route.setHasParent(true);
                    parent.setHasParent(true);
                    return;
                }
            }
        });
        router = new VueRouter<>();
        router.setPath("/profile");
        router.setName("个人中心");
        router.setComponent("personal/Profile");
        router.setIcon("none");
        router.setMeta(new RouterMeta(true, false));
        topRoutes.add(router);

        ArrayList<VueRouter<T>> list = new ArrayList<>();
        VueRouter<T> root = new VueRouter<>();
        root.setName("主页");
        root.setComponent("MenuView");
        root.setIcon("none");
        root.setPath("/");
        root.setRedirect("/home");
        root.setChildren(topRoutes);
        list.add(root);

        return list;
    }
}