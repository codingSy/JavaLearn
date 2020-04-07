/*
 * Copyright (C) 2018 1129798381@qq.com All rights reserved.
 *
 * Created by 1129798381@qq.com on 2020/2/23.
 */

package com.codingsy.javalearn.print;

/**
 * 蛇形打印.
 *
 * @author 1129798381@qq.com
 */
public class PrintSnake {
    static int length = 80;
    static int width = 4;

    private static void printLength(int begin) {
        int thisLength = 0;
        boolean print = true;
        while (thisLength < length) {
            if (begin == width) {
                begin = 0;
                print = !print;
            }
            if (print) {
                System.out.print("*");
                begin++;
            } else {
                System.out.print(" ");
                begin++;
            }
            thisLength++;
        }
        System.out.println();
    }

    private static void printWidth() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                if (j % 4 == 0) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }


    }

    public static void main(String[] args) {
        printLength(0);
        printWidth();
        printLength(width);
    }
}
