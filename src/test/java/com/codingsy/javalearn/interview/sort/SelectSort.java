/*
 * Copyright (C) 2018 1129798381@qq.com All rights reserved.
 *
 * Created by 1129798381@qq.com on 2020/2/25.
 */

package com.codingsy.javalearn.interview.sort;

/**
 * 选择排序.
 *
 * @author 1129798381@qq.com
 */
public class SelectSort {

    public static void main(String[] args) {
//        int[] arr = {4, 23, 15, 3, 2, 22, 5, 76, 87, 11, 7};
//        sort(arr);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + ",");
//        }

        int[] arr1 = {7,2};
        int index = find(arr1);
        System.out.println(index);
    }

    private static void sort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int value = arr[i];
            int position = i;
            for (int j = i + 1; j < len; j++) {//找到最小的值和位置
                if (arr[j] < value) {
                    value = arr[j];
                    position = j;
                }
            }
            arr[position] = arr[i];//进行交换
            arr[i] = value;

        }
    }

    // 1.遍历找到最大值和第二大值，如果最大值比第二大值三倍还大，说明存在
    public static int find(int[] arr){
        if(arr.length<1){
            return -1;
        }
        if(arr.length==1){
            return 0;
        }
        // 最大元素位置
        int index = 0;
        // 最大值
        int max = arr[0];
        Integer secMax = null;
        for(int i = 1; i<arr.length;i++){
            if(arr[i]>max){
                secMax = max;
                max = arr[i];
                index = i;
            } else if(secMax == null){
                secMax = arr[i];
            } else if(arr[i]>secMax){
                secMax=arr[i];
            }
        }
        System.out.println(max);
        System.out.println(secMax);
        if(max>secMax*3){
            return index;
        }
        return -1;
    }
}
