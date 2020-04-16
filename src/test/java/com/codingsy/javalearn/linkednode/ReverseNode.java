package com.codingsy.javalearn.linkednode;/*
 * Copyright (C) 2018 1129798381@qq.com All rights reserved.
 *
 * Created by 1129798381@qq.com on 2020/3/24.
 */

/**
 * 翻转链表.
 *
 * @author 1129798381@qq.com
 */
public class ReverseNode {
    public static void main(String[] args) {
        LinkedNode node1 = new LinkedNode(1);
        LinkedNode node2 = new LinkedNode(2);
        LinkedNode node3 = new LinkedNode(3);
        LinkedNode node4 = new LinkedNode(4);
        LinkedNode node5 = new LinkedNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println("链表翻转前:" + node1.toString());
        LinkedNode reverseNode = reverseNode(node1);
        System.out.println("链表翻转后:" + reverseNode.toString());
    }

    // 1->2->3->4->5
    // 1<-2<-3<-4<-5
    public static LinkedNode reverseNode(LinkedNode node) {
        LinkedNode pre = null;
        while (node != null) {
            LinkedNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

}
