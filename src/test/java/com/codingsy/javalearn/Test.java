/*
 *
 * Created by 1129798381@qq.com on 2020/4/28.
 */

package com.codingsy.javalearn;

import java.util.Random;

/**
 * 描述类的功能.
 *
 * @author 112798381@qq.com
 */
public class Test {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int nextInt = random.nextInt(3);
            System.out.println(nextInt);
        }


    }
}
