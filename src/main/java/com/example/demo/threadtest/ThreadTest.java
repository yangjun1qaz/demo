package com.example.demo.threadtest;

/**
 * @author ：Brayden
 * @date ：Created in 2021/3/15 10:55
 * @description：
 * @modified By：
 * @version:
 */
public class ThreadTest extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread() + "正在执行");
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            ThreadTest threadTest = new ThreadTest();
            threadTest.start();
            try {
                threadTest.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread() + "主线程正在执行");
    }
}



