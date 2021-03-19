package com.example.demo.jvm;
public class TestStackDeep {
    private int count = 0;

    public void testAdd() {
        count++;
        testAdd();
    }

    public void test() {
        try {
            testAdd();
        } catch (Throwable e) {
            System.out.println(e);
            System.out.println("栈深度:" + count);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        while(true){
            new TestStackDeep().test();
        }

    }
}