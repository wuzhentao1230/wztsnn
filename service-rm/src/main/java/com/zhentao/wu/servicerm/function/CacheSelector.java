package com.zhentao.wu.servicerm.function;

@FunctionalInterface
public interface CacheSelector<T> {
    T select() throws Exception;
}
