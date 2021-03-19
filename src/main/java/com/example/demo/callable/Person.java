package com.example.demo.callable;


public class Person {

    private String  ss;

    public Person() {

    }

    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }

    @Override
    public String toString() {
        return "Person{" +
                "ss='" + ss + '\'' +
                '}';
    }
}
