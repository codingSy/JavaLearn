package com.codingsy.javalearn.interview.linkednode;

public class LinkedNode {
        public int value;
        public LinkedNode next;

        public LinkedNode(int data) {
            this.value = data;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            LinkedNode node = this;
            while (node != null) {
                stringBuilder.append(node.value);
                stringBuilder.append(",");
                node = node.next;
            }
            return stringBuilder.toString();
        }

    }