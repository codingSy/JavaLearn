package com.codingsy.javalearn.interview.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 合并两个有序数组
 */
public class MergeList {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(2);
        list1.add(4);
        list1.add(6);
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(1);
        list2.add(3);
        list2.add(5);
        List<Integer> list = sort(list1, list2);
        System.out.println(list);
    }

    public static List<Integer> sort(List<Integer> list1, List<Integer> list2) {
        int aLength = list1.size();
        int bLength = list2.size();
        List<Integer> result = new ArrayList<Integer>();
        int i = 0, j = 0;
        while (aLength > i && bLength > j) {
            if (list1.get(i) > list2.get(j)) {
                result.add(i + j, list2.get(j));
                j++;
            } else {
                result.add(i + j, list1.get(i));
                i++;
            }
        }
        // list2元素已排好序， list1还有剩余元素
        while (aLength > i) {
            result.add(i + j, list1.get(i));
            i++;
        }
        // list1元素已排好序，list2还有剩余元素
        while (bLength > j) {
            result.add(i + j, list2.get(j));
            j++;
        }
        return result;
    }
}