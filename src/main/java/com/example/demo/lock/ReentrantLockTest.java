package com.example.demo.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Brayden
 * @version 1.0
 * @date 2020/10/20
 */
public class ReentrantLockTest {

    public static void main(String[] args) throws InterruptedException {

        final int[] count = {0};

        long startTIme = System.currentTimeMillis();

        ReentrantLock reentrantLock = new ReentrantLock();
        for (int i = 0; i < 1000; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                  reentrantLock.lock();
                    int a = count[0];
                    count[0] = a + 1;
                   reentrantLock.unlock();
                }
            }).start();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTIme);
        Thread.sleep(180);
        System.out.println("count[0]=" + count[0]);
    }
}
