package com.codingsy.javalearn.tree;

import java.util.ArrayList;

/**
 * 查找二叉树中和为某一值的路径
 * 思路：
 * 首先，采用一种“减法”思想，当检查一棵树从根到叶子节点形成的路径的和是否为target时，
 * 先将当前根节点的值 root.val 加入path, 然后检查它的左子树（若非空），
 * 看从左子树的根到叶子节点形成的路径的和是否为 target - root.val (递归),
 * 然后同样的道理去递归检查右子树（若非空）。
 * 若左右子树检查均不成功，就把当前路径最新的一个节点去除，继续遍历。
 * <p>
 * 其次，题目要求返回所有满足条件的路径，就需要两个list，
 * 一个list用来记录当前的路径Path，一个list记录当前所有满足条件的路径Paths，
 * 若当前路径满足条件，加到Paths中。
 */
public class FindTreePath {
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    static ArrayList<Integer> path = new ArrayList<>();


    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode node1 = new TreeNode(1, node2, node3);

        ArrayList<ArrayList<Integer>> arrayLists = FindPath(node1, 8);
        System.out.println(arrayLists);

    }


    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return res;
        }
        path.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList(path));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        path.remove(path.size() - 1);
        return res;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;

        }
    }
}