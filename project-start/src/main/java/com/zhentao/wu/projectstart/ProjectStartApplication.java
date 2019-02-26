package com.zhentao.wu.projectstart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//开启事务
@EnableTransactionManagement
//可以对某个方法添加线程池
@EnableAsync

@MapperScan("com.zhentao.wu.servicewx.dao")

//@ComponentScan(basePackages = "com.tao.wztsnn.rmsystem.controller.entity")
@ServletComponentScan
@SpringBootApplication(scanBasePackages = {"com.zhentao.wu"})
public class ProjectStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectStartApplication.class, args);
    }

}
