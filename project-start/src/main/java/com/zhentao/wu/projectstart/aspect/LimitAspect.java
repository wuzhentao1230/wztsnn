package com.zhentao.wu.projectstart.aspect;

import com.google.common.util.concurrent.RateLimiter;
import com.zhentao.wu.projectstart.annotation.Limit;
import com.zhentao.wu.projectstart.config.RateLimiterConfig;
import com.zhentao.wu.projectstart.entity.ResultBean;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
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
        //判断能否在1秒内得到令牌，如果不能则立即返回false，不会阻塞程序
        if (!rateLimiter.tryAcquire(1000, TimeUnit.MILLISECONDS)){
            logger.info("服务器繁忙开始抛弃了"+name);
            ResultBean resultBean = new ResultBean();
            resultBean.makeBusy("name:"+name+",method:"+methodName+"-->被限流了");
            return resultBean;
        }
        Object result = point.proceed();
        return result;

    }

    /**
     * 限流脚本
     * 调用的时候不超过阈值，则直接返回并执行计算器自加。
     *
     * @return lua脚本get获取值  incr将key中储存的数字值增一   expire是用来给键设置过期时间
     *
     *
     * String luaScript = buildLuaScript();
     * RedisScript<Number> redisScript = new DefaultRedisScript<>(luaScript, Number.class);
     * Number count = limitRedisTemplate.execute(redisScript, keys, limitCount, limitPeriod);
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
