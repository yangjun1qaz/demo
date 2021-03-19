package com.example.demo.threadtest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author ：Brayden
 * @date ：Created in 2021/3/15 14:25
 * @description：
 * @modified By：
 * @version:
 */
public class CallableTest implements Callable{
    @Override
    public Object call() throws Exception {
        return "I execute";
    }
    public static void main(String[] args) {
        CallableTest callableTest = new CallableTest();
        FutureTask<String> FutureTask = new FutureTask<String>(callableTest);
        new Thread(FutureTask).start();

        try {
            String s = FutureTask.get();
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
