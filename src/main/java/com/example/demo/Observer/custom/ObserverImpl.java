package com.example.demo.Observer.custom;

/**
 * @author ：Brayden
 * @date ：Created in 2021/3/25 18:37
 * @description：
 * @modified By：
 * @version:
 */
public class ObserverImpl implements Observer {
    String s;

    public ObserverImpl(String s) {
        this.s = s;
    }

    @Override
    public void update(int a, int b) {
        System.out.println(s+"----a="+a+"b="+b);
    }
}
