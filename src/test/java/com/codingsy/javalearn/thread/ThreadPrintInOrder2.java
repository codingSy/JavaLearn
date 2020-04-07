/*
 * Copyright (C) 2018 1129798381@qq.com All rights reserved.
 *
 * Created by 1129798381@qq.com on 2020/2/23.
 */

package com.codingsy.javalearn.thread;

import java.util.concurrent.Semaphore;

/**
 * 多线程顺序打印十次abc.
 *
 * @author 1129798381@qq.com
 */
public class ThreadPrintInOrder2 {
    private static Semaphore spA = new Semaphore(1);
    private static Semaphore spB = new Semaphore(0);
    private static Semaphore spC = new Semaphore(0);

    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    spA.acquire();// A获取信号执行,A信号量减1,当A为0时将无法继续获得该信号量
                    System.out.println("第" + (i + 1) + "次打印---" + "a");
                    spB.release();// B释放信号，B信号量加1（初始为0），此时可以获取B信号量
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread b = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    spB.acquire();
                    System.out.println("第" + (i + 1) + "次打印---" + "b");
                    spC.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread c = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    spC.acquire();
                    System.out.println("第" + (i + 1) + "次打印---" + "c");
                    spA.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        a.start();
        b.start();
        c.start();
    }

}
