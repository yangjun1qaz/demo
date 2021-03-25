package com.example.demo.Observer.jdkp;

import java.util.Observable;

/**
 * @author ：Brayden
 * @date ：Created in 2021/3/25 18:54
 * @description：
 * @modified By：
 * @version:
 */
public class OberverableImpl extends Observable {

    private int a;
    private int b;

    public void setInfo(int a,int b){
        this.a=a;
        this.b=b;
        setChanged();
        notifyObservers();
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
