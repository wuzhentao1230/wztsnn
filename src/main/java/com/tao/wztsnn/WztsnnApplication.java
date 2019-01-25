package com.tao.wztsnn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//开启事务
@EnableTransactionManagement
//可以对某个方法添加线程池
@EnableAsync

@MapperScan("com.tao.wztsnn.*.dao")

//@ComponentScan(basePackages = "com.tao.wztsnn.topentity")
@ServletComponentScan
@SpringBootApplication
public class WztsnnApplication {

    public static void main(String[] args) {
        SpringApplication.run(WztsnnApplication.class, args);
    }

}

