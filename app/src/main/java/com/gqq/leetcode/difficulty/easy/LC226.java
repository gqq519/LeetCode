package com.gqq.leetcode.difficulty.easy;

import com.gqq.leetcode.TreeNode;

/**
 * Invert a binary tree.
 *
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * Trivia:
 * This problem was inspired by this original tweet by Max Howell:
 *
 * Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.
 *
 * 解法说明：
 * 反转树的左右节点，利用递归的方式，反转每一个节点下的左右子节点。
 *
 *
 */
public class LC226 {

    public TreeNode invertTree(TreeNode root) {
        TreeNode node = root;
        implInvert(node);
        return node;
    }

    // 反转传入的树的左右子节点
    public void implInvert(TreeNode node) {
        if (node == null) return;
        // 存在左右子节点，交换
        if (node.left != null || node.right != null) {
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            // 遍历子节点下的节点
            implInvert(node.left);
            implInvert(node.right);
        }

    }
}
