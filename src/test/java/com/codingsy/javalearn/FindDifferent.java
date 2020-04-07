/*
 * Copyright (C) 2018 1129798381@qq.com All rights reserved.
 *
 * Created by 1129798381@qq.com on 2020/4/1.
 */

package com.codingsy.javalearn;

/**
 * 描述类的功能.
 *
 * @author 1129798381@qq.com
 */
public class FindDifferent {

    public static void main(String[] args) {
        char[] arr1 = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        char[] arr2 = {'a', 'b', 'c', 'd', 'f', 'g'};
        find(arr1, arr2);
    }

    public static boolean find(char[] arr1, char[] arr2) {
        int size = arr1.length >= arr2.length ? arr2.length : arr1.length;
        for (int i = 0; i < size; i++) {
            if (arr1[i]!=(arr2[i])) {
                System.out.println("发现不同的字符：" + arr1[i]);
                return true;
            }
        }
        System.out.println("未发现不同的字符！");
        return false;
    }
}
