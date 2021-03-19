package com.example.demo.threadtest;

import java.util.concurrent.CountDownLatch;

/**
 * @author ：Brayden
 * @date ：Created in 2021/3/15 14:54
 * @description：
 * @modified By：
 * @version:
 */
public class CountDownLatchTest {

    public void test() {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread() + "正在执行");
                countDownLatch.countDown();
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new CountDownLatchTest().test();
        System.out.println(Thread.currentThread() + "我是主线程");
    }
}
