/*
 * Copyright (C) 2018 1129798381@qq.com All rights reserved.
 *
 * Created by 1129798381@qq.com on 2020/4/2.
 */

package com.codingsy.javalearn.interview.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 描述类的功能.
 *
 * @author 1129798381@qq.com
 */
public class LRUCache2 extends LinkedHashMap {
    private final int CACHE_SIZE;

    // 这里就是传递进来最多能缓存多少数据
    public LRUCache2(int cacheSize) {
        // 根据cacheSize和加载因子计算hashmap的capactiy，+1确保当达到cacheSize上限时不会触发hashmap的扩容
        // 同时最后一个true指的是让linkedhashmap按照访问顺序来进行排序，最近访问的放在头，最老访问的就在尾
        super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
        CACHE_SIZE = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > CACHE_SIZE;
    }

    public static void main(String[] args) {
        LRUCache2 lruCache2 = new LRUCache2(3);
        lruCache2.put("a", 1);
        lruCache2.put("b", 2);
        lruCache2.put("c", 3);
        lruCache2.put("d", 4);
        lruCache2.put("e", 5);
        System.out.println(lruCache2);
        System.out.println(lruCache2.get("a"));
    }
}
