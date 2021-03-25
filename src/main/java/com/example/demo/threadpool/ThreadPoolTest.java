package com.example.demo.threadpool;

import java.util.StringJoiner;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

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
        int maximunPoolSize=4;
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
                       new CustomThreadFactory(),
                       new CustomRejectedExecutionHandler());

        for(int i=0;i<100;i++){
            final int index = (i + 1);
            threadPoolExecutor.execute(()->{
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                StringJoiner stringJoiner = new StringJoiner(",");
                System.out.println(stringJoiner.add("我是").add(index+"").add("线程").add(Thread.currentThread().getName()));
            });
        }
    }
}

 class CustomThreadFactory implements ThreadFactory {

    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        String threadName = ThreadPoolTest.class.getSimpleName() + count.addAndGet(1);
        System.out.println(threadName);
        t.setName(threadName);
        return t;
    }
}


class CustomRejectedExecutionHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        // 记录异常
        // 报警处理等
        try {
            executor.getQueue().put(r);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("error............."+Thread.currentThread().getName());
    }
}
