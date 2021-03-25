package com.example.demo.Observer.custom;

/**
 * @author ：Brayden
 * @date ：Created in 2021/3/25 18:44
 * @description：
 * @modified By：
 * @version:
 */
public class MainTest {
    public static void main(String[] args) throws Exception {
        ObserverableImpl observerable = new ObserverableImpl();
        Observer brayden = new ObserverImpl("brayden");
        Observer cuite = new ObserverImpl("cuite");
        observerable.addObserver(brayden);
        observerable.addObserver(cuite);
        observerable.setInfomation(1,4);
    }
}
