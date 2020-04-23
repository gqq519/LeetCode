package com.gqq.leetcode.difficulty.easy;

import com.gqq.leetcode.TreeNode;

/**
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its depth = 3.
 *
 * 解法说明：
 * 利用递归的方式求得结点的深度。
 * 递归退出的条件是节点是空的时候，深度为0，取根结点的左节点和右节点中的最大深度再加1即是树的深度
 *
 */
public class LC104 {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
