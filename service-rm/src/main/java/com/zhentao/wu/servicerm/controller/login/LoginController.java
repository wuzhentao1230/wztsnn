package com.zhentao.wu.servicerm.controller.login;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhentao.wu.automybatis.mapper.TUserMapper;
import com.zhentao.wu.automybatis.model.TUser;
import com.zhentao.wu.servicerm.authentication.JWTToken;
import com.zhentao.wu.servicerm.authentication.JWTUtil;
import com.zhentao.wu.servicerm.domain.ActiveUser;
import com.zhentao.wu.servicerm.entity.RmResultBean;
import com.zhentao.wu.servicerm.service.LoginService;
import com.zhentao.wu.servicerm.util.DateUtil;
import com.zhentao.wu.servicerm.util.MD5Util;
import com.zhentao.wu.servicerm.util.RMUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
public class LoginController {

    private static final String TOKEN = "Authentication";

    @Autowired
    private TUserMapper tUserMapper;

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public RmResultBean login(@RequestBody String requestData, HttpServletRequest request) throws Exception {
        RmResultBean rmResultBean = new RmResultBean();

        JSONObject jsonObject = JSON.parseObject(requestData);
        if (!jsonObject.containsKey("userName") || !jsonObject.containsKey("password")){
            final String errorMessage = "用户名或密码为空";
        }
        String userName = jsonObject.getString("userName");
        String password = jsonObject.getString("password");


        userName = StringUtils.lowerCase(userName);
        password = MD5Util.encrypt(userName, password);

        final String errorMessage = "用户名或密码错误";
        // 通过用户名查询用户信息
        Example exampleQuery = new Example(TUser.class);
        exampleQuery.createCriteria().andEqualTo("username",userName);
        TUser user = tUserMapper.selectOneByExample(exampleQuery);

        if (user == null)
            return rmResultBean.makeFail("账号不存在");
        if (!StringUtils.equals(user.getPassword(), password))
            return rmResultBean.makeFail("密码错误");
        if ("0".equals(user.getStatus()))
            return rmResultBean.makeFail("账号已被锁定,请联系管理员！");

        //        // 更新用户登录时间
        //        this.userService.updateLoginTime(userName);
        //        // 保存登录记录
        //        LoginLog loginLog = new LoginLog();
        //        loginLog.setuserName(userName);
        //        this.loginLogService.saveLoginLog(loginLog);

        String token = RMUtil.encryptToken(JWTUtil.sign(userName, password));
        LocalDateTime expireTime = LocalDateTime.now().plusSeconds(86400L);
        String expireTimeStr = DateUtil.formatFullTime(expireTime);
        JWTToken jwtToken = new JWTToken(token, expireTimeStr);

        Map<String, Object> userInfo = loginService.generateUserInfo(jwtToken, user);
        loginService.saveUserInfoToRedis(user, userInfo,jwtToken, request);
        rmResultBean.makeSuccess(userInfo);
        return rmResultBean;
    }

    @GetMapping("/get_info")
    @ResponseBody
    public RmResultBean get_info(ServletRequest request){
        try{
            HttpServletRequest req = (HttpServletRequest) request;
            String token = req.getHeader(TOKEN);
            ActiveUser userInfo = loginService.getUserInfo(token);
            return new RmResultBean().makeSuccess(userInfo);
        }catch (Exception e){
            e.printStackTrace();
            return new RmResultBean().makeFail("get_info fail,info:"+e.getMessage());
        }
    }

    @PostMapping("register")
    @ResponseBody
    public RmResultBean register(@NotBlank(message = "{required}") String userName,
                                 @NotBlank(message = "{required}") String password,
                                 String email,
                                 String mobile){
        try{
            TUser tUser = new TUser();
            password = MD5Util.encrypt(userName, password);
            tUser.setUsername(userName);
            tUser.setPassword(password);
            tUser.setEmail(email);
            tUser.setMobile(mobile);
            return loginService.registUser(tUser);
        }catch (Exception e){
            e.printStackTrace();
            return new RmResultBean().makeFail("register fail,info:"+e.getMessage());
        }
    }

}
