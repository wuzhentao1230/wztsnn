package com.zhentao.wu.servicerm.service;

import com.alibaba.fastjson.JSONObject;
import com.zhentao.wu.automybatis.model.TUser;
import com.zhentao.wu.servicerm.authentication.JWTToken;
import com.zhentao.wu.servicerm.domain.ActiveUser;
import com.zhentao.wu.servicerm.specialmapper.TUserMapperS;
import com.zhentao.wu.servicerm.util.AddressUtil;
import com.zhentao.wu.servicerm.util.IPUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class LoginService {

    @Autowired
    private RedisService redisService;

    @Autowired
    private TUserMapperS tUserMapperS;
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
    public Map<String, Object> generateUserInfo(JWTToken token, TUser user) {
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
    public String saveTokenToRedis(TUser user, JWTToken token, HttpServletRequest request) throws Exception {
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
