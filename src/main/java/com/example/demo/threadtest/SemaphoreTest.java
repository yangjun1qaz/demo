package com.example.demo.threadtest;

import java.util.concurrent.Semaphore;

/**
 * @author ：Brayden
 * @date ：Created in 2021/3/15 15:11
 * @description：
 * @modified By：
 * @version:
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "抢到了车位");
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }).start();
        }
    }
}
