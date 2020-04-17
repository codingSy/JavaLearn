/*
 * Copyright (C) 2018 1129798381@qq.com All rights reserved.
 *
 * Created by 1129798381@qq.com on 2020/2/23.
 */

package com.codingsy.javalearn.interview.lock;

/**
 * 死锁示例.
 *
 * @author 1129798381@qq.com
 */
public class DeadLock {
    private static Object m = new Object();
    private static Object n = new Object();

    public static void main(String[] args) {
        Thread mn = new Thread(() -> {
            try {
                mn();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread nm = new Thread(() -> {
            try {
                nm();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        mn.start();
        nm.start();
    }

    public static void mn() throws InterruptedException {
        synchronized (m) {
            System.out.println("mn---执行m...");
            Thread.sleep(2000L);
            System.out.println("mn---等待获取n锁...");
            synchronized (n) {
                System.out.println("mn---执行n...");
                Thread.sleep(2000L);
            }
        }
    }

    public static void nm() throws InterruptedException {
        synchronized (n) {
            System.out.println("nm---执行n...");
            Thread.sleep(2000L);
            System.out.println("nm---等待获取m锁...");
            synchronized (m) {
                System.out.println("nm---执行m...");
                Thread.sleep(2000L);
            }
        }
    }
}
