/*
 * Copyright (C) 2018 1129798381@qq.com All rights reserved.
 *
 * Created by 1129798381@qq.com on 2020/2/26.
 */

package com.codingsy.javalearn.search;

/**
 * 二分查找.
 *
 * @author 1129798381@qq.com
 */
public class BinarySerch {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 7, 11, 15, 22, 23, 76, 87, 92, 94, 99, 101, 110, 123, 158};
        int search = search(arr, 1);
        System.out.println(search);
    }

    /**
     * 二分查找数组中某一个字符的位置.
     * @param arr 数组
     * @param key 关键字
     * @return 关键字在所在数组中的位置，未找到返回-1
     */
    private static int search(int[] arr, int key) {
        int begin = 0;
        int end = arr.length-1;
        while (begin < end - 1) {
            int mid = (begin + end) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                end = mid;
            } else if (arr[mid] < key) {
                begin = mid;
            }
        }
        return -1;
    }
}
