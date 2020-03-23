package com.zhentao.wu.projectstart;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//开启事务
@EnableTransactionManagement
//可以对某个方法添加线程池
@EnableAsync
@EnableCaching

//tk.mybatis.spring.annotation.MapperScan 通用Mapper注解
@MapperScan({"com.zhentao.wu.*.mapper","com.zhentao.wu.*.specialmapper","com.zhentao.wu.*.dao"})

@ServletComponentScan
@SpringBootApplication(scanBasePackages = {"com.zhentao.wu"})
public class ProjectStartApplication {

    //是一种可以方便的进行http请求接口的方式
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ProjectStartApplication.class, args);
    }

}
