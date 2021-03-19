package com.example.demo.threadtest;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author ：Brayden
 * @date ：Created in 2021/3/15 15:01
 * @description：
 * @modified By：
 * @version:
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {

            CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
                System.out.println("召唤神龙");
            });

            for (int i = 0; i < 7; i++) {
                final int temp=i;

                new Thread(() -> {
                    System.out.println("召唤第"+temp+"龙珠");
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        }
    }
