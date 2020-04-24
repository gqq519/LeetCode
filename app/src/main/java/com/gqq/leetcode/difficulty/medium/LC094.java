package com.gqq.leetcode.difficulty.medium;

import com.gqq.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 *
 * 解法说明：
 * 树的中序遍历
 */
public class LC094 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversalTree(root, result);
        return result;
    }

    public void traversalTree(TreeNode node, List<Integer> res) {
        if (node != null) {
            if (node.left != null) {
                traversalTree(node.left, res);
            }
            res.add(node.val);
            if (node.right != null) {
                traversalTree(node.right, res);
            }

        }
    }
}
