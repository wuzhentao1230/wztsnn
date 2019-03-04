package com.zhentao.wu.projectstart;

import com.zhentao.wu.servicewx.service.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectStartApplicationTests {
    @Autowired
    DemoService demoService;
    @Test
    public void contextLoads() {
        demoService.query();
    }

}
