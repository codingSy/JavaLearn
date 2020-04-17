/*
 * Copyright (C) 2018 1129798381@qq.com All rights reserved.
 *
 * Created by 1129798381@qq.com on 2020/4/1.
 */

package com.codingsy.javalearn.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 求交集.
 *
 * @author 1129798381@qq.com
 */
public class FindRetian {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int[] arr2 = {2, 4, 5};
        List list = retanAll(arr1, arr2);
        System.out.println("交集：" + list);
    }

    public static List retanAll(int[] arr1, int[] arr2) {
        Map map1 = new HashMap();
        for (int i = 0; i < arr1.length; i++) {
            map1.put(i, arr1[i]);
        }
        List list = new ArrayList();
        for (int i = 0; i < arr2.length; i++) {
            if (map1.containsKey(arr2[i])) {
                list.add(arr2[i]);
            }
        }
        return list;
    }
}
