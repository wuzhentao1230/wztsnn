package com.zhentao.wu.projectstart.executor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

@Component
public class AsyncDemo {

    // 任务一;
    @Async("taskExecutor1")
    public void doTaskOne() {
        System.out.println("开始做任务一");
    }

    // 任务二;
    @Async("taskExecutor1")
    public void doTaskTwo(String msg) throws Exception {
        System.out.println("开始做任务二,"+msg);
    }

    // 任务3;
    @Async("taskExecutor1")
    public Future<String> doTaskThree() throws Exception {
        System.out.println("开始做任务三");
        Future<String> future;
        try {
            Thread.sleep(1000 * 1);
            future = new AsyncResult<String>("success");
        } catch (InterruptedException e) {
            future = new AsyncResult<String>("error");
        }
        return future;
    }
}
