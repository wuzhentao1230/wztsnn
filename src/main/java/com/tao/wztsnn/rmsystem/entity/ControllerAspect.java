package com.tao.wztsnn.rmsystem.entity;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 切面类
 */
@Aspect
@Component
public class ControllerAspect {
    private static Logger logger = LoggerFactory.getLogger(ControllerAspect.class);
    /**
     * Pointcut定义切点
     * public修饰符的   返回值任意  com.cy.controller包下面的任意类的任意方法任意参数
     */
    @Pointcut("execution(public * com.tao.wztsnn.rmsystem.controller.*.*(..)) || execution(public * com.tao.wztsnn.wx.controller.*.*(..))")
    public void log(){

    }

    @Around("log()")
    public Object aroundMethod(ProceedingJoinPoint pjd){
        Object result = null;
        String methodName = pjd.getSignature().getName();
        //获取request
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();


        //请求url
        String url = request.getRequestURI();
        ResultBean bean = new ResultBean();
        try {
            //前置通知
            logger.warn("url: "+url+" parameters with " + Arrays.asList(pjd.getArgs()));
            //执行目标方法
            result = pjd.proceed();
            bean.makeSuccess(result);
            //返回通知
        } catch (Throwable e) {
            bean.makeFail("The method " + methodName + " occurs exception:" + e);
            //异常通知
            logger.error("The method " + methodName + " occurs exception:" + e);
        }

        return bean;
    }
}
