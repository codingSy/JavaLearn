/*
 * Copyright (C) 2018 1129798381@qq.com All rights reserved.
 *
 * Created by 1129798381@qq.com on 2020/1/14.
 */

package com.codingsy.javalearn.interview.single;

/**
 * 单例-恶汉式.
 *
 * @author 1129798381@qq.com
 */
public class HungrySingle {

    // 在静态初始化器中创建单例实例，这段代码保证了线程安全
    private static HungrySingle single = new HungrySingle();

    //Singleton类只有一个构造方法并且是被private修饰的，所以用户无法通过new方法创建该对象实例
    private HungrySingle() {

    }

    public static HungrySingle getSingle() {
        return single;
    }
}
