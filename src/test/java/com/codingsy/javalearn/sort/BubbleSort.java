/*
 * Copyright (C) 2018 1129798381@qq.com All rights reserved.
 *
 * Created by 1129798381@qq.com on 2020/2/25.
 */

package com.codingsy.javalearn.sort;

import java.util.ArrayList;

/**
 * 冒泡排序.
 * 相邻两个元素比较大小，双层循环
 * @author 1129798381@qq.com
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {4, 23, 15, 3, 2, 22, 5, 76, 87, 11, 7};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+",");
        }
    }

    private static void sort(int[] arr) {
        new ArrayList<>();
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length - i; j++) {
                if (arr[j-1] > arr[j]) {
                    int m = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = m;
                }
            }
        }
    }
}
