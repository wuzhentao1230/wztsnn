package com.zhentao.wu.servicerm.controller.menu;

import com.zhentao.wu.automybatis.model.TMenu;
import com.zhentao.wu.servicerm.domain.router.VueRouter;
import com.zhentao.wu.servicerm.service.impl.MenuServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuServiceIml menuServiceIml;

    @GetMapping("/{username}")

    public ArrayList<VueRouter<TMenu>> getUserRouters(@NotBlank(message = "{required}") @PathVariable String username) {
        return this.menuServiceIml.getUserRouters(username);
    }
}
