package com.codingsy.javalearn.interview.tree;

import java.util.ArrayList;

/**
 * 查找二叉树中和为某一值的路径
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 *
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。v
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

        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node8 = new TreeNode(2, null, null);
        TreeNode node9 = new TreeNode(5, null, null);
        TreeNode node10 = new TreeNode(1, null, null);

        TreeNode node4 = new TreeNode(11, node7, node8);
        TreeNode node5 = new TreeNode(13, null, null);
        TreeNode node6 = new TreeNode(4, node9, node10);

        TreeNode node2 = new TreeNode(4, node4, null);
        TreeNode node3 = new TreeNode(8, node5, node6);
        TreeNode node1 = new TreeNode(5, node2, node3);

        ArrayList<ArrayList<Integer>> arrayLists = FindPath(node1, 22);
        System.out.println(arrayLists);

    }

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int sum) {
        if (root == null) {
            return res;
        }
        path.add(root.val);
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList(path));
            path.remove(path.size() - 1);
            return res;
        }
        FindPath(root.left, sum);
        FindPath(root.right, sum);
        path.remove(path.size() - 1);
        return res;
    }

}