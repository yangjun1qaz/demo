package com.example.demo.threadtest;

/**
 * @author ：Brayden
 * @date ：Created in 2021/3/15 14:15
 * @description：
 * @modified By：
 * @version:
 */
public class RunableTest implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread() + "正在执行");
    }

    public static void main(String[] args) {
       new Thread(new RunableTest()).start();
    }
}
