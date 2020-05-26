/*
 * Copyright (C) 2018 1129798381@qq.com All rights reserved.
 *
 * Created by 1129798381@qq.com on 2020/4/1.
 */

package com.codingsy.javalearn.interview;

/**
 * 描述类的功能.
 *
 * @author 1129798381@qq.com
 */
public class BigIntAdd {

    public static void main(String[] args) {
        String arr1 = "1234567890";
        String arr2 = "9876543210";
        String result = add(arr1, arr2);
        System.out.println(result);
    }

    public static String add(String arr1, String arr2) {
        StringBuilder arr1Sb =new StringBuilder(arr1);
        StringBuilder arr2Sb =new StringBuilder(arr2);
        char[] chars1 = arr1Sb.reverse().toString().toCharArray();
        char[] chars2 = arr2Sb.reverse().toString().toCharArray();
        int size = chars1.length >= chars2.length ? chars1.length : chars2.length;

        StringBuilder result = new StringBuilder();
        int temp = 0;
        for (int i = 0; i < size; i++) {
            char a = '0';
            char b = '0';

            if (i<chars1.length) {
                a = chars1[i];
            }
            if (i<chars2.length) {
                b = chars2[i];
            }
            int sum = Integer.valueOf(a+"") + Integer.valueOf(b+"") + temp;
            if(sum>=10){
                temp = sum/10;
            }
            result.append(sum%10);
        }
        return result.reverse().toString();
    }
}
