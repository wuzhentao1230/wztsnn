package com.zhentao.wu.servicerm.controller.login;

import com.zhentao.wu.automybatis.mapper.TUserMapper;
import com.zhentao.wu.automybatis.model.TUser;
import com.zhentao.wu.servicerm.authentication.JWTToken;
import com.zhentao.wu.servicerm.authentication.JWTUtil;
import com.zhentao.wu.servicerm.entity.RmResultBean;
import com.zhentao.wu.servicerm.exception.FebsException;
import com.zhentao.wu.servicerm.service.LoginService;
import com.zhentao.wu.servicerm.util.DateUtil;
import com.zhentao.wu.servicerm.util.MD5Util;
import com.zhentao.wu.servicerm.util.RMUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private TUserMapper tUserMapper;

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public RmResultBean login(
            @NotBlank(message = "{required}") String username,
            @NotBlank(message = "{required}") String password, HttpServletRequest request) throws Exception {
        RmResultBean rmResultBean = new RmResultBean();

        username = StringUtils.lowerCase(username);
        password = MD5Util.encrypt(username, password);

        final String errorMessage = "用户名或密码错误";
        // 通过用户名查询用户信息
        Example exampleQuery = new Example(TUser.class);
        exampleQuery.createCriteria().andEqualTo("username",username);
        TUser user = tUserMapper.selectOneByExample(exampleQuery);

        if (user == null)
            return rmResultBean.makeFail("账号不存在");
        if (!StringUtils.equals(user.getPassword(), password))
            return rmResultBean.makeFail("密码错误");
        if ("0".equals(user.getStatus()))
            throw new FebsException("账号已被锁定,请联系管理员！");

//        // 更新用户登录时间
//        this.userService.updateLoginTime(username);
//        // 保存登录记录
//        LoginLog loginLog = new LoginLog();
//        loginLog.setUsername(username);
//        this.loginLogService.saveLoginLog(loginLog);

        String token = RMUtil.encryptToken(JWTUtil.sign(username, password));
        LocalDateTime expireTime = LocalDateTime.now().plusSeconds(86400L);
        String expireTimeStr = DateUtil.formatFullTime(expireTime);
        JWTToken jwtToken = new JWTToken(token, expireTimeStr);

        String userId = loginService.saveTokenToRedis(user, jwtToken, request);
        //给TUser添加private transient String id;
        user.setId(userId);

        Map<String, Object> userInfo = loginService.generateUserInfo(jwtToken, user);
        rmResultBean.makeSuccess(userInfo);
        return rmResultBean;
    }

    @PostMapping("register")
    @ResponseBody
    public RmResultBean register(@NotBlank(message = "{required}") String username,
                                 @NotBlank(message = "{required}") String password,
                                 String email,
                                 String mobile){
        try{
            TUser tUser = new TUser();
            tUser.setUsername(username);
            tUser.setPassword(password);
            tUser.setEmail(email);
            tUser.setMobile(mobile);
            return loginService.registUser(tUser);
        }catch (Exception e){
            return new RmResultBean().makeFail("register fail,info:"+e.getMessage());
        }
    }

}
