/*
 * Copyright (C) 2018 1129798381@qq.com All rights reserved.
 *
 * Created by 1129798381@qq.com on 2020/2/23.
 */

package com.codingsy.javalearn.interview.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多线程顺序打印十次abc.
 *
 * @author 1129798381@qq.com
 */
public class ThreadPrintInOrder1 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(new Task("a", 0));
        executor.execute(new Task("b", 1));
        executor.execute(new Task("c", 2));
        executor.shutdown();
    }

    static class Task implements Runnable {

        private String one;
        private int count;
        private static int num = 0;

        public Task(String one, int count) {
            this.one = one;
            this.count = count;
        }

        @Override
        public void run() {

            int i = 0;
            while (i < 10) {
                synchronized (Task.class) {
                    if (num % 3 == count) {
                        num++;
                        System.out.println("第" + (i + 1) + "次打印---" + one);
                    } else {
                        continue;
                    }
                }
                i++;
            }
        }
    }
}
