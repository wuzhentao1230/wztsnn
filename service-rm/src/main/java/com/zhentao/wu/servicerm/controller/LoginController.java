package com.zhentao.wu.servicerm.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhentao.wu.automybatis.mapper.TUserMapper;
import com.zhentao.wu.automybatis.model.TUser;
import com.zhentao.wu.servicerm.authentication.JWTToken;
import com.zhentao.wu.servicerm.authentication.JWTUtil;
import com.zhentao.wu.servicerm.domain.ActiveUser;
import com.zhentao.wu.servicerm.entity.RmResultBean;
import com.zhentao.wu.servicerm.exception.FebsException;
import com.zhentao.wu.servicerm.service.RedisService;
import com.zhentao.wu.servicerm.specialmapper.TUserMapperS;
import com.zhentao.wu.servicerm.util.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
public class LoginController {
    @Autowired
    private TUserMapper tUserMapper;
    @Autowired
    private RedisService redisService;
    @Autowired
    private TUserMapperS tUserMapperS;
    @PostMapping("/login")
    public Object login(
            @NotBlank(message = "{required}") String username,
            @NotBlank(message = "{required}") String password, HttpServletRequest request) throws Exception {
        username = StringUtils.lowerCase(username);
        password = MD5Util.encrypt(username, password);

        final String errorMessage = "用户名或密码错误";
        // 通过用户名查询用户信息
        Example exampleQuery = new Example(TUser.class);
        exampleQuery.createCriteria().andEqualTo("username",username);
        TUser user = tUserMapper.selectOneByExample(exampleQuery);

        if (user == null)
            throw new FebsException(errorMessage);
        if (!StringUtils.equals(user.getPassword(), password))
            throw new FebsException(errorMessage);
        if ("0".equals(user.getStatus()))
            throw new FebsException("账号已被锁定,请联系管理员！");

//        // 更新用户登录时间
//        this.userService.updateLoginTime(username);
//        // 保存登录记录
//        LoginLog loginLog = new LoginLog();
//        loginLog.setUsername(username);
//        this.loginLogService.saveLoginLog(loginLog);

        String token = FebsUtil.encryptToken(JWTUtil.sign(username, password));
        LocalDateTime expireTime = LocalDateTime.now().plusSeconds(86400L);
        String expireTimeStr = DateUtil.formatFullTime(expireTime);
        JWTToken jwtToken = new JWTToken(token, expireTimeStr);

        String userId = this.saveTokenToRedis(user, jwtToken, request);
        user.setId(userId);

        Map<String, Object> userInfo = this.generateUserInfo(jwtToken, user);
        return userInfo;
    }
    /**
     * 生成前端需要的用户信息，包括：
     * 1. token
     * 2. Vue Router
     * 3. 用户角色
     * 4. 用户权限
     * 5. 前端系统个性化配置信息
     *
     * @param token token
     * @param user  用户信息
     * @return UserInfo
     */
    private Map<String, Object> generateUserInfo(JWTToken token, TUser user) {
        String username = user.getUsername();
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("token", token.getToken());
        userInfo.put("exipreTime", token.getExipreAt());

        Set<String> roles = this.tUserMapperS.getRoles(username);
        userInfo.put("roles", roles);

        Set<String> permissions = this.tUserMapperS.getPermission(username);
        userInfo.put("permissions", permissions);

        user.setPassword("it's a secret");
        userInfo.put("user", user);
        return userInfo;
    }
    private String saveTokenToRedis(TUser user, JWTToken token, HttpServletRequest request) throws Exception {
        String ip = IPUtil.getIpAddr(request);

        // 构建在线用户
        ActiveUser activeUser = new ActiveUser();
        activeUser.setUsername(user.getUsername());
        activeUser.setIp(ip);
        activeUser.setToken(token.getToken());
        activeUser.setLoginAddress(AddressUtil.getCityInfo(1, ip));

        // zset 存储登录用户，score 为过期时间戳
        this.redisService.zadd("user.active", Double.valueOf(token.getExipreAt()), JSONObject.toJSONString(activeUser));
        // redis 中存储这个加密 token，key = 前缀 + 加密 token + .ip
        this.redisService.set("cache.token." + token.getToken() + "." + ip, token.getToken(), 86400L * 1000);

        return activeUser.getId();
    }
}
