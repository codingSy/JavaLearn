/*
 * Copyright (C) 2018 www.missfresh.cn All rights reserved.
 *
 * Created by shaoying@missfresh.cn on 2020/4/13.
 */

package com.codingsy.javalearn;

/**
 * 股票买卖问题.
 * 给定一个数组代表股票每天的价格，
 * 请问只能买卖一次的情况下，最大化利润是多少？
 * 输入: {100, 80, 120, 130, 70, 60, 100, 125}
 * 只能买一次：65（60 买进，125 卖出）
 *
 * @author 112798381@qq.com
 */
public class StockTrade {

    public static void main(String[] args) {

        int[] arr = {100, 80, 120, 130, 70, 60, 100, 125};
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] arr) {
        int low = arr[0];
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (low >= arr[i]) {
                low = arr[i];
            }
            if (max < arr[i] - low) {
                max = arr[i] - low;
                System.out.println("最佳买入点：" + low + ",最佳卖出点：" + arr[i]);
            }
        }
        return max;
    }
}
