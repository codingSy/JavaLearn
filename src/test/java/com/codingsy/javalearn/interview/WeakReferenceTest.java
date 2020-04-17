/*
 * Copyright (C) 2018 1129798381@qq.com All rights reserved.
 *
 * Created by 1129798381@qq.com on 2020/3/23.
 */

package com.codingsy.javalearn.interview;

import java.lang.ref.WeakReference;

/**
 * 描述类的功能.
 *
 * @author 1129798381@qq.com
 */
public class WeakReferenceTest {
    public static void main(String[] args) {
        String str = new String("Struts2权威指南");
        //创建一个弱引用，让这个弱引用引用到“Struts2权威指南”字符串
        WeakReference weakReference = new WeakReference(str);
        //切断str引用和“Struts2权威指南”字符串之间的引用
        str = null;
        //取出弱引用所引用的对象
        System.out.println(weakReference.get());
        //强制进行垃圾回收
        System.gc();
        System.runFinalization();
        //再次取出弱引用所引用的对象
        System.out.println(weakReference.get());

    }

}
