package com.gqq.leetcode.difficulty.medium;

import com.gqq.leetcode.TreeNode;
import com.gqq.leetcode.tag.tree.Tree;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *
 * Example 1:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * Example 2:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 *
 *
 * Note:
 *
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the binary tree.
 *
 * 解法说明：
 * 主要判断子树中是否包含p/q
 *
 */
public class LC236 {

    //  写的太繁琐了
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val && containNode(root, q)
        ||root.val == q.val && containNode(root, p)) {
            return root;
        } else if ((containNode(root.left, p) && containNode(root.right, q))
                || (containNode(root.left, q) && containNode(root.right, p))){
            return root;
        } else if (containNode(root.left, p)) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }

    public boolean containNode(TreeNode root, TreeNode node) {
        if (root == null) return false;
        if (root.val == node.val) {
            return true;
        }
        return containNode(root.left, node) || containNode(root.right, node);
    }

    // 参考答案
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }
}
