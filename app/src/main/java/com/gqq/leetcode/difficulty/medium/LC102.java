package com.gqq.leetcode.difficulty.medium;

import com.gqq.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 解法说明：层序遍历
 * 利用队列的先入先出的特点，从根结点开始按顺序，根结点 - 根结点的左右非null子节点 - 节点出队 ----
 * 1. 首先将根结点入队，循环遍历队中的数据，直到队中没有数据
 * 2. 循环内逻辑：每一轮while循环队中的数量都是该层的数据个数，for循环的作用
 *      1 入队一个根结点  个数为1  利用for循环遍历并添加左右非空子节点 根结点出队
 *      2 然后再遍历队中的元素，分别再添加每个节点的左右非空子节点  然后再分别出队，依次循环
 *
 */
public class LC102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) return res;
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelNums = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < levelNums; i++) {
                if (queue.peek().left != null) queue.add(queue.peek().left);
                if (queue.peek().right != null) queue.add(queue.peek().right);
                list.add(queue.poll().val);
            }
            res.add(list);
        }
        return res;
    }
}
