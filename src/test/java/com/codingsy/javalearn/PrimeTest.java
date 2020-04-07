/*
 * Copyright (C) 2018 1129798381@qq.com All rights reserved.
 *
 * Created by 1129798381@qq.com on 2020/3/6.
 */

package com.codingsy.javalearn;

/**
 * 获取比N大的下一个质数 8 -> 11.
 *
 * @author 1129798381@qq.com
 */
public class PrimeTest {

    public static void main(String[] args) {
        getNextPrime(8);
    }

    /**
     * 获取比N大的下一个质数 8 -> 11
     *
     * @param n
     * @return
     */
    public static int getNextPrime(int n) {
        while (true) {
            int m = ++n;
            int size = 0;
            for (int i = 1; i < m; i++) {
                int a = m % i;
                if (a == 0) {
                    size++;
                }
                if (size >= 2) {
                    break;
                }
                if (size < 2 && i == m - 1) {
                    System.out.println("找到质数：" + m);
                    return m;
                }
            }
        }

    }
}
