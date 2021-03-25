package com.example.demo.Observer.custom;

import java.util.Iterator;
import java.util.Vector;

/**
 * @author ：Brayden
 * @date ：Created in 2021/3/25 18:38
 * @description：
 * @modified By：
 * @version:
 */
public class ObserverableImpl implements Observerable {
    private Vector<Observer> vector;
    private int a;
    private int b;

    public ObserverableImpl() {
        vector = new Vector<>();
    }

    @Override
    public void addObserver(Observer observer) throws Exception {
        if (observer == null) {
            throw new Exception();
        }
        vector.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) throws Exception {
        if (observer == null) {
            throw new Exception();
        }
        vector.remove(observer);
    }

    @Override
    public void notifyObserver() {
        Iterator<Observer> iterator = vector.iterator();
        while (iterator.hasNext()) {
            iterator.next().update(a, b);
        }
    }

    public void setInfomation( int a,int b){
        this.a = a;
        this.b = b;
        //信息更新完毕，通知所有观察者
        notifyObserver();
    }
}
