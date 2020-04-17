package com.codingsy.javalearn.interview.lru;

import java.util.Hashtable;

/**
 * LRU原理及实现
 * 参考：https://blog.csdn.net/hopeztm/article/details/79547052
 */
public class LRUCache1 {

    private Hashtable<String, DLinkedNode>
            cache = new Hashtable<>();
    private int count;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache1(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        head.pre = null;

        tail = new DLinkedNode();
        tail.next = null;

        head.next = tail;
        tail.pre = head;
    }

    public int get(String key) {

        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1; // should raise exception here.
        }

        // move the accessed node to the head;
        this.moveToHead(node);

        return node.value;
    }


    public void set(String key, int value) {
        DLinkedNode node = cache.get(key);

        if (node == null) {

            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            this.cache.put(key, newNode);
            this.addNode(newNode);

            ++count;

            if (count > capacity) {
                // pop the tail
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        } else {
            // update the value.
            node.value = value;
            this.moveToHead(node);
        }
    }

    /**
     * Always add the new node right after head;
     */
    private void addNode(DLinkedNode node) {
        node.pre = head;
        node.next = head.next;

        head.next.pre = node;
        head.next = node;
    }

    /**
     * Remove an existing node from the linked list.
     */
    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.next;

        pre.next = post;
        post.pre = pre;
    }

    /**
     * Move certain node in between to the head.
     */
    private void moveToHead(DLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }
    // pop the current tail.
    private DLinkedNode popTail() {
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }

    class DLinkedNode {
        String key;
        int value;
        DLinkedNode pre;
        DLinkedNode next;
    }

    public static void main(String[] args) {
        LRUCache1 LRUCache1 = new LRUCache1(3);
        LRUCache1.set("a", 1);
        LRUCache1.set("b", 2);
        LRUCache1.set("c", 3);
        LRUCache1.set("d", 4);
        LRUCache1.set("e", 5);
        System.out.println(LRUCache1);
        System.out.println(LRUCache1.get("a"));
    }
}