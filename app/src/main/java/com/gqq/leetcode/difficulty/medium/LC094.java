package com.gqq.leetcode.difficulty.medium;

import com.gqq.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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
 * 树的中序遍历，
 * 1、利用递归的方式
 * 2、借助栈
 *
 * 中序遍历：左节点、父节点、右节点
 *
 */
public class LC094 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversalTree(root, result);
        return result;
    }

    // 递归遍历的方式
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

    // 借助栈先进后出的特点，首先将根节点左子树的叶子节点进行入栈，然后是左子树叶子节点的父节点，其次是父节点的右叶子节点
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
