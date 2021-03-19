package com.example.demo.callable;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;


public class Callable {
    public static void main(String[] args) {
//
//        for(int i=0;i<100;i++){
//            test();
//        }

       // Person person = (Person) null;
      //  System.out.println(person);

        Person person = new Person();


        JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(person));
        System.out.println(jsonObject);

    }


    public static void  test(){
        // 定义工作线程的结果集合

        final Map<String, Object> worksResult = new ConcurrentHashMap<String, Object>();
        //任务Future集合
        List<Future<Object>> futures = new ArrayList<>();
        final CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService executor = Executors.newFixedThreadPool(3);// 线程池
        // 查询当前天气线程
        Future<Object> future = executor.submit(new java.util.concurrent.Callable<Object>() {
            @Override
            public Object call(){
                try {
                    worksResult.put("ss","thread--1");
                } catch (Exception e) {

                }
                return new Object();
            }
        });
        futures.add(future);
        // 查询空气质量线程
        Future<Object> future1 = executor.submit(new java.util.concurrent.Callable<Object>() {
            @Override
            public Object call(){
                try {
                    worksResult.put("yy","thread--2");
                } catch (Exception e) {

                }
                return new Object();
            }
        });
        futures.add(future1);
        // 查询空气质量线程
        Future<Object> future2 = executor.submit(new java.util.concurrent.Callable<Object>() {
            @Override
            public Object call(){
                try {
                    for(long i=0;i<1000000000l;i++){

                    }
                    worksResult.put("zz","thread--3");
                } catch (Exception e) {

                }
                return new Object();
            }
        });
        futures.add(future2);

        //关闭线程
        executor.shutdown();
        //异常处理
        for (int i = 0; i < futures.size(); i++) {
            Future<Object> f = futures.get(i);
            if (f != null) {
                try {
                    //阻塞等待线程执行完毕
                    f.get();
                } catch (InterruptedException | ExecutionException e) {


                }
            }
        }
        Object ss = worksResult.get("ss");
        Object yy = worksResult.get("yy");
        Object zz = worksResult.get("zz");
        System.out.println("ss="+ss+" yy="+yy+"  zz="+zz);

    }
}
