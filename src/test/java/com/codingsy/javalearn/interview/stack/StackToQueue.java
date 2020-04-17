/*
 * Copyright (C) 2018 112798381@qq.com All rights reserved.
 *
 * Created by 112798381@qq.com on 2020/4/7.
 */

package com.codingsy.javalearn.interview.stack;

import java.util.Stack;

/**
 * @author 112798381@qq.com
 */
public class StackToQueue {
    private static Stack<Integer> stack1 = new Stack<>();
    private static Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        System.out.println(pop());
        push(4);
        push(5);
        System.out.println(pop());

    }

    private static Integer pop() {

        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        int val = stack2.pop();
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        return val;

    }

    private static void push(int val) {
        stack1.push(val);
    }

}
