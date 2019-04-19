package com.zhentao.wu.servicerm.function;


@FunctionalInterface
public interface JedisExecutor<T, R> {
    R excute(T t) ;
}
