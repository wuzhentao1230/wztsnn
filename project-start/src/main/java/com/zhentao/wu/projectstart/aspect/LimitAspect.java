package com.zhentao.wu.projectstart.aspect;

import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.RateLimiter;
import com.zhentao.wu.projectstart.annotation.Limit;
import com.zhentao.wu.projectstart.config.RateLimiterConfig;
import com.zhentao.wu.projectstart.entity.ResultBean;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class LimitAspect {
    private static final Logger logger = LoggerFactory.getLogger(LimitAspect.class);



    @Pointcut("@annotation(com.zhentao.wu.projectstart.annotation.Limit)")
    public void pointcut() {
        // do nothing
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        String methodName = point.getSignature().getName();
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        Limit limitAnnotation = method.getAnnotation(Limit.class);
        String name = limitAnnotation.name();
        String key = limitAnnotation.key();
        float limitCount = limitAnnotation.count();

        if (!RateLimiterConfig.rateLimiterMap.containsKey(key)){
            RateLimiter rateLimiter = RateLimiter.create(limitCount);
            RateLimiterConfig.rateLimiterMap.put(key,rateLimiter);
        }
        RateLimiter rateLimiter = RateLimiterConfig.rateLimiterMap.get(key);
        if (!rateLimiter.tryAcquire(1000, TimeUnit.MILLISECONDS)){
            logger.info("服务器繁忙开始抛弃这个请求");
            ResultBean resultBean = new ResultBean();
            resultBean.makeBusy("方法"+methodName+"限流了");
            return resultBean;
        }
        Object result = point.proceed();
        return result;

    }

    /**
     * 限流脚本
     * 调用的时候不超过阈值，则直接返回并执行计算器自加。
     *
     * @return lua脚本
     */
    private String buildLuaScript() {
        return "local c" +
                "\nc = redis.call('get',KEYS[1])" +
                "\nif c and tonumber(c) > tonumber(ARGV[1]) then" +
                "\nreturn c;" +
                "\nend" +
                "\nc = redis.call('incr',KEYS[1])" +
                "\nif tonumber(c) == 1 then" +
                "\nredis.call('expire',KEYS[1],ARGV[2])" +
                "\nend" +
                "\nreturn c;";
    }


}
