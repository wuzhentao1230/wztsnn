package com.zhentao.wu.projectstart.config;

import com.google.common.util.concurrent.RateLimiter;

import java.util.HashMap;
import java.util.Map;

public class RateLimiterConfig {
    public static Map<String, RateLimiter> rateLimiterMap= new HashMap();
}
