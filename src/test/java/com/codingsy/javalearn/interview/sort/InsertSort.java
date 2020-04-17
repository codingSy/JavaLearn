/*
 * Copyright (C) 2018 1129798381@qq.com All rights reserved.
 *
 * Created by 1129798381@qq.com on 2020/2/25.
 */

package com.codingsy.javalearn.interview.sort;

/**
 * 插入排序.
 * @author 1129798381@qq.com
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {4, 23, 15, 3, 2, 22, 5, 76, 87, 11, 7};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+",");
        }
    }

    private static void sort(int[] arr) {
        int len=arr.length;//单独把数组长度拿出来，提高效率
        int insertNum;//要插入的数
        for (int i = 1; i <len ; i++) {//因为第一次不用，所以从1开始
            insertNum=arr[i];
            int j=i-1;//序列元素个数
            while (j>=0&&arr[j]>=insertNum){//从后往前循环，将大于insertNum的数向后移动
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=insertNum;//找到位置，插入当前元素
        }
    }
}
