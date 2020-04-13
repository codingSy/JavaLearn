package com.codingsy.javalearn.linknode;/*
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
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println("链表翻转前:" + node1.toString());
        Node reverseNode = reverseNode(node1);
        System.out.println("链表翻转后:" + reverseNode.toString());
    }

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            Node node = this;
            while (node != null) {
                stringBuilder.append(node.value);
                stringBuilder.append(",");
                node = node.next;
            }
            return stringBuilder.toString();
        }

    }

    // 1->2->3->4->5
    // 1<-2<-3<-4<-5
    public static Node reverseNode(Node node) {
        Node pre = null;
        while (node != null) {
            Node next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

}
