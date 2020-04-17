/*
 * Copyright (C) 2018 1129798381@qq.com All rights reserved.
 *
 * Created by 1129798381@qq.com on 2020/2/26.
 */

package com.codingsy.javalearn.interview.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 同步静态方法锁的对象是类.
 * 同步非静态方法锁的是实例对象.
 * 一个实例对象同时调用两个非静态同步方法时，只能获得其中一个方法执行权
 *
 * @author 1129798381@qq.com
 */
public class SyncRunTest {
    ExecutorService executor =  Executors.newFixedThreadPool(1);
    public static void main(String[] args) {
        Thread staticStartA = new Thread(() -> {
            staticStartA();
        });
        Thread staticStartB = new Thread(() -> {
            staticStartB();
        });

        Thread staticStartC = new Thread(() -> {
            staticStartC();
        });
        staticStartA.start();
        staticStartB.start();
        staticStartC.start();


        SyncRunTest testThread = new SyncRunTest();
        Thread startA = new Thread(() -> {
            testThread.startA();
        });
        Thread startB = new Thread(() -> {
            testThread.startB();
        });

        Thread startC = new Thread(() -> {
            testThread.startC();
        });
        startA.start();
        startB.start();
        startC.start();
    }

    private static synchronized void staticStartA() {
        try {
            System.out.println("synchronized静态方法staticStartA执行.....");
            Thread.sleep(2000L);
            System.out.println("synchronized静态方法staticStartA执行完成！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void staticStartB() {
        try {
            System.out.println("静态方法staticStartB执行.....");
            Thread.sleep(2000L);
            System.out.println("静态方法staticStartB执行完成！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized static void staticStartC() {
        try {
            System.out.println("synchronized静态方法staticStartC执行.....");
            Thread.sleep(2000L);
            System.out.println("synchronized静态方法staticStartC执行完成！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void startA() {
        try {
            System.out.println("synchronized非静态方法startA...");
            Thread.sleep(2000L);
            System.out.println("synchronized非静态方法startA完成！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void startB() {
        try {
            System.out.println("非静态方法startB..");
            Thread.sleep(2000L);
            System.out.println("非静态方法startB完成！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void startC() {
        try {
            System.out.println("非静态方法startC..");
            Thread.sleep(2000L);
            System.out.println("非静态方法startC完成！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
