package com.gqq.leetcode.difficulty.medium;

import com.gqq.leetcode.TreeNode;
import com.gqq.leetcode.tag.tree.Tree;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 *     2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 * Output: true
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
 * 解法说明：
 * 判断是不是二叉查找树：左子树所有节点都小于当前节点值，右子树所有节点都大于当前节点值
 * 1. 利用递归的方式，需要注意的是，递归的层级不能太深，否则会超时或溢出
 * 2. 递归退出的条件：root节点为null，说明以上父节点都符合，返回true，左子树不为空&左子树节点大于父节点--false，右子树不为空&右子树节点小于父节点--false
 *
 */
public class LC098 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(15);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(20);
        node2.left = node3;
        node2.right = node4;
        root.left = node1;
        root.right = node2;

        isValidBST(root);

    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) return false;
        return isValidTree(root, null, null);
    }

    private static boolean isValidTree(TreeNode root, Integer low, Integer high) {
        if (root ==  null) return true;
        if (low != null && low >= root.val) return false;
        if (high != null && high <= root.val) return false;
        // 直接 return isValidTree(root.left, low, root.val) && isValidTree(root.right, root.val, high); 测试时会超时
        if (!isValidTree(root.left, low, root.val)) return false;
        if (!isValidTree(root.right, root.val, high)) return false;
        return true;
    }

}
