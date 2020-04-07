/*
 * Copyright (C) 2018 1129798381@qq.com All rights reserved.
 *
 * Created by 1129798381@qq.com on 2020/1/14.
 */

package com.codingsy.javalearn.single;

/**
 * 单例-懒汉式(双重检查加锁版本).
 *
 * @author 1129798381@qq.com
 */
public class LazySingle {

    // //volatile保证，当single变量被初始化成LazySingle实例时，多个线程可以正确处理single变量
    private static volatile LazySingle single;

    //Singleton类只有一个构造方法并且是被private修饰的，所以用户无法通过new方法创建该对象实例
    private LazySingle() {

    }

    public static LazySingle getSingle() {
        //检查实例，如果不存在，就进入同步代码块
        if (single == null) {
            //只有第一次才彻底执行这里的代码
            synchronized (LazySingle.class) {
                //进入同步代码块后，再检查一次，如果仍是null，才创建实例
                if (single == null) {
                    single = new LazySingle();
                }
            }
        }
        return single;
    }
}
