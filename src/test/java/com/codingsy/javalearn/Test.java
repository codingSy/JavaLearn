/*
 * Copyright (C) 2018 www.missfresh.cn All rights reserved.
 *
 * Created by shaoying@missfresh.cn on 2020/4/7.
 */

package com.codingsy.javalearn;

/**
 * 给定一个数组代表股票每天的价格，
 * 请问只能买卖一次的情况下，最大化利润是多少？
 * 输入: {100, 80, 120, 130, 70, 60, 100, 125}
 * 只能买一次：65（60 买进，125 卖出）.
 *
 * @author 112798381@qq.com
 */
public class Test {

    public static void main(String[] args) {
        findLastKey(4);

    }

    // n个鸡蛋放入盒子中
    public static void findLastKey(int n) {
        int i = 1;
        int sum = 1;
        int last = 0;
        while (sum <= n) {
            last = sum;
            System.out.println(last);
            i = i * 2;
            sum = sum + i;
        }
        int key = n - last;
        if (key == 0) {
            System.out.println("最后一个放:" + i/2);
        } else {
            System.out.println("最后一个放:" + key);
        }

    }

}
