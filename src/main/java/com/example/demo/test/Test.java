package com.example.demo.test;

/**
 * @author Brayden
 * @version 1.0
 * @date 2020/5/6 16:45
 */
public class Test {

    public static void main(String[] args) throws Exception {
        String s = HttpClientUtil.httpGetRequest("http://localhost:9195/order/test/soulTest");
        System.out.println(s);
    }

}
