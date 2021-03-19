package com.example.demo.lambda;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author Brayden
 * @version 1.0
 * @date 2020/10/10
 */
public class Lambda1 {

    @Test
    public void test1() {
        Comparator<Integer> comparator = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        System.out.println(comparator.compare(2, 1));
    }


    //使用lambda
    @Test
    public void test2() {
        Comparator<Integer> comparator = (a, b) -> Integer.compare(a, b);
        System.out.println(comparator.compare(1, 2));
    }

    @Test
    public void test3() {
        new Runnable() {

            @Override
            public void run() {
                System.out.println("hahah");
            }
        };
    }

    @Test
    public void test4() {
        Runnable runnable = () -> System.out.println("hahahhah");
    }

    @Test
    public void test5(){
        Consumer<String> consumer=a-> System.out.println(a);
        consumer.accept("sdfs");
    }

    @Test
    public void test6(){
        Consumer<Integer> consumer=(a)->{
            Integer x=a;
            Integer y=1;
            System.out.println(x+y);
        };
        consumer.accept(1);
    }





    public static void main(String[] args) {
        Lambda1 lambda1 = new Lambda1();
    }
}
