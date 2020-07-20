package com.gqq.leetcode.offer;

import com.gqq.leetcode.TreeNode;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *  
 *
 * 示例 1：
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof
 */
public class Offer27 {
    public TreeNode mirrorTree(TreeNode root) {
        TreeNode node = root;
        mirror(node);
        return node;
    }

    private void mirror(TreeNode root) {
        if (root == null) return;
        if (root.left != null || root.right != null) {
            TreeNode node = root.left;
            root.left = root.right;
            root.right = node;

            mirror(root.left);
            mirror(root.right);
        }

    }
}
