package com.example.demo.jvm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author ：Brayden
 * @date ：Created in 2021/2/5 17:43
 * @description：
 * @modified By：
 * @version:
 */
public class TestOutOfMemory {
    public void test(){
        int count = 0;
        HashMap<String,String> hashMap = new HashMap<String,String>();
        for(int i=0;i<100000;i++){
            hashMap.put("key"+i,"brayden"+i);
        }
        List<Object> list = new ArrayList<Object>();
        try {
            while (true) {
                list.add(new Object());
                Thread.sleep(1);
                count++;
            }
        } catch (Throwable e) {
            System.out.print(e);
//          System.out.print("count: "+count+ "new Object().size"+SizeOfObject.sizeOf(list));
        }
    }


    /**
     * @param args
     */
    public static void main(String[] args) {

        new TestOutOfMemory().test();
    }
}
