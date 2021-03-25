package com.example.demo.Observer.custom;

/**
 * @author ：Brayden
 * @date ：Created in 2021/3/25 18:34
 * @description：
 * @modified By：
 * @version:
 */
public interface Observerable {
    public void addObserver(Observer observer) throws Exception;

    public void removeObserver(Observer observer) throws Exception;

    public void notifyObserver();
}
