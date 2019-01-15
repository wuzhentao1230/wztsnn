package com.tao.wztsnn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//开启事务
@EnableTransactionManagement
//可以对某个方法添加线程池
@EnableAsync
public class WztsnnApplication {

    public static void main(String[] args) {
        SpringApplication.run(WztsnnApplication.class, args);
    }

}

