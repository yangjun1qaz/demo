package com.example.demo.threadpool;

import java.util.StringJoiner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ：Brayden
 * @date ：Created in 2021/3/19 16:54
 * @description：
 * @modified By：
 * @version:
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        int corePoolSize=2;
        int maximunPoolSize=2;
        long keepLiveTime=2;
        TimeUnit seconds = TimeUnit.SECONDS;
        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(2);
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(
                        corePoolSize,
                        maximunPoolSize,
                        keepLiveTime,
                        seconds,
                        queue,
                       new CustomRejectedExecutionHandler());

        for(int i=0;i<8;i++){
            final int index = (i + 1);
            threadPoolExecutor.execute(()->{
                StringJoiner stringJoiner = new StringJoiner(",");
                System.out.println(stringJoiner.add("我是").add(index+"").add("线程"));
            });
        }
    }
}

 class CustomRejectedExecutionHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        // 记录异常
        // 报警处理等
        System.out.println("error.............");
    }
}
