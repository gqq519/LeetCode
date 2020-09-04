package com.gqq.leetcode.everyday;

import com.gqq.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 *
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 *
 * 解题说明：
 * 1. 深度优先遍历：利用递归的方式
 *    递归退出条件：node节点为null，已经遍历完了
 *    递归完的条件：node的左右节点都为null，要将存入的string添加到list里面了
 *    递归的条件：node的左右节点不全为null，要进行递归左右子节点
 * 2. 广度优先遍历：利用队列的特点
 *
 *
 *
 */
public class LC257 {

    // 1 递归的方式
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        getTreePath(list, "", root);
        return list;
    }

    private void getTreePath(List<String> list, String path, TreeNode root) {
        if (root == null) return;

        StringBuilder string = new StringBuilder(path);
        string.append(root.val);

        if (root.left == null && root.right == null) {
            list.add(string.toString());
        } else {
            string.append("->");
            getTreePath(list, string.toString(), root.left);
            getTreePath(list, string.toString(), root.right);
        }
    }

    // 2 广度优先遍历
    public List<String> binaryTreePaths1(TreeNode root) {
        List<String> list = new ArrayList<>();

        Queue<TreeNode> queueNode = new ArrayDeque<>();
        Queue<String> queueStr = new ArrayDeque<>();
        queueNode.offer(root);
        queueStr.offer(Integer.toString(root.val));

        while (!queueNode.isEmpty()) {
            // TODO: 2020/9/4  
        }

        return list;
    }
}
