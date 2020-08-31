package com.gqq.leetcode.offer;

import com.gqq.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 *  
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof
 *
 * 解题说明：
 * 首先通过Queue的先进先出的特点，其次for循环利用Queue的遍历取出数据
 * 注意点：for循环遍历queue的数据时，因为循环中Queue的会被添加数据，所以需要在最开始获取Queue的长度作为循环的条件
 *
 */
public class Offer32_2 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode root1 = new TreeNode(9);
        TreeNode root2 = new TreeNode(20);
        TreeNode root11 = new TreeNode(15);
        TreeNode root22 = new TreeNode(7);
        root.left = root1;
        root.right = root2;
        root2.left = root11;
        root2.right = root22;
        levelOrder(root);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();

            // 易错点：i的范围，因为循环里queue的长度会发生变化，所以i的范围是先取queue.size()
            for (int i = queue.size(); i > 0; i--) {
                TreeNode treeNode = queue.poll();
                list.add(treeNode.val);
                if (treeNode.left != null) queue.add(treeNode.left);
                if (treeNode.right != null) queue.add(treeNode.right);
            }
            res.add(list);
        }
        return res;
    }
}
