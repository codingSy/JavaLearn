/*
 * Copyright (C) 2018 1129798381@qq.com All rights reserved.
 *
 * Created by 1129798381@qq.com on 2020/2/23.
 */

package com.codingsy.javalearn.interview.print;

/**
 * .
 * 打印等腰三角形
 * 在控制台中打印出如下所示的等腰三角形，等腰三角形行数为n
 *     1
 *    1 1
 *   1 1 1
 *  1 1 1 1
 * 1 1 1 1 1
 * @author 1129798381@qq.com
 */
public class PrintIsoscelesTriangle {

    public static void main(String[] args){
        print(10);
    }

    // 1.第一层打印位置n-1,打印一个1
    // 2.第m层打印位置n-m,打印m个1
    public static void print(int n){
        for (int i = 0; i < n; i++) {
            // 第ceng层
            for(int x =0;x<n-i; x++){
                System.out.print(" ");
            }
            for(int y =0;y<i; y++){
                System.out.print("1 ");
            }
            System.out.println();
        }
    }

}
