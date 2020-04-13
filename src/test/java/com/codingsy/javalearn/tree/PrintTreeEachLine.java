/*
 * Copyright (C) 2018 1129798381@qq.com All rights reserved.
 *
 * Created by 1129798381@qq.com on 2020/2/27.
 */

package com.codingsy.javalearn.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行.
 * 例如：
 *       1
 *   2       3
 * 4   5   6   7
 *
 * 输出：1,2,3,4,5,6,7
 * @author 1129798381@qq.com
 */
public class PrintTreeEachLine {
    public static void main(String[] args) {
        TreeNode tree4 = new TreeNode(4, null, null);
        TreeNode tree5 = new TreeNode(5, null, null);
        TreeNode tree6 = new TreeNode(6, null, null);
        TreeNode tree7 = new TreeNode(7, null, null);
        TreeNode tree2 = new TreeNode(2, tree4, tree5);
        TreeNode tree3 = new TreeNode(3, tree6, tree7);
        TreeNode tree1 = new TreeNode(1, tree2, tree3);

        List<List<Integer>> list = new ArrayList();
        getNodeList(tree1, 1, list);

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + ",");
            }
        }
    }

    public static void getNodeList(TreeNode tree, int depth, List<List<Integer>> list) {
        if (tree == null) {
            return;
        }

        if (depth > list.size()) {
            list.add(new ArrayList<>());
        }
        // 把每一行数据加到list里
        list.get(depth - 1).add(tree.val);

        getNodeList(tree.left, depth + 1, list);
        getNodeList(tree.right, depth + 1, list);
    }

}
