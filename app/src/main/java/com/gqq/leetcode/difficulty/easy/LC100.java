package com.gqq.leetcode.difficulty.easy;

import com.gqq.leetcode.TreeNode;

/**
 * Given two binary trees, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 *
 * Example 1:
 *
 * Input:     1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * Output: true
 * Example 2:
 *
 * Input:     1         1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * Output: false
 *
 * 解法说明：
 *
 *
 */
public class LC100 {

    public static void main(String[] args) {

    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        StringBuilder strp = new StringBuilder();
        StringBuilder strq = new StringBuilder();
        printNode(strp, p);
        printNode(strq, q);
        return strp.toString().equals(strq.toString());
    }

    public static void printNode(StringBuilder builder, TreeNode node) {
        if (node == null) return;
        builder.append(node.val);
        printNode(builder, node.left);
        printNode(builder, node.right);
    }



    // 数组转换为树
    public static TreeNode convertTree(int[] data) {
        TreeNode node = null;

        return node;
    }
}
