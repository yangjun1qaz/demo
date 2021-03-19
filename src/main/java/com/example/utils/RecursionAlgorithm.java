package com.example.utils;

/**
 * 递归算法
 *
 * @author Brayden
 * @version 1.0
 * @date 2020/4/3 22:39
 */
public class RecursionAlgorithm {

    public static void main(String[] args) {
        test();
        test2(9);
    }

    /**
     * 九九乘法表
     */
    public static void test() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "*" + j + "=" + i * j + " ");
            }
            System.out.println();
        }
    }

    /**
     * 九九乘法表
     *
     * @param m 初始值：9
     */
    public static void test2(int m) {
        if (m == 1) {
            System.out.println(1 + "*" + 1 + "=" + 1 * 1 + " ");
        } else if (m > 1) {
            test2(--m);
            for (int i = 1; i <= m; i++) {
                System.out.print(i + "*" + m + "=" + i * m + " ");
            }
            System.out.println();
        }
    }
}

