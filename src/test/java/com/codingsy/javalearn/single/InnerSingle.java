/*
 * Copyright (C) 2018 1129798381@qq.com All rights reserved.
 *
 * Created by 1129798381@qq.com on 2020/1/14.
 */

package com.codingsy.javalearn.single;

/**
 * 单例-匿名内部类方式式.
 *
 * @author 1129798381@qq.com
 */
public class InnerSingle {

    private InnerSingle() {

    }

    public static InnerSingle getSingle() {
        return Inner.SINGLE;
    }

    private static class Inner {
        private static final InnerSingle SINGLE = new InnerSingle();
    }
}
