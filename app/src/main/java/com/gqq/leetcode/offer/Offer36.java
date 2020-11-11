package com.gqq.leetcode.offer;

import com.gqq.leetcode.Node;
import com.gqq.leetcode.Node;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *
 *     public int val;
 *     public Node left;
 *     public Node right;
 *
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 *
 * 解题思路：
 * 1、进行二叉搜索树的中序遍历，中序遍历的结果是一个递增序列
 * 2、形成双向链表，相邻节点pre和cur，使pre.right = cur, cur.left = pre
 * 3. 形成循环链表，头节点head和尾节点tail，使head.left = tail，tail.right = head
 *
 * 中序遍历：左节点、节点、右节点，二叉搜索树中序遍历后是一个有序数组
 * dfs(node.left)
 * print(node.val)
 * dfs(node.right)
 *              4
 *             / \
 *            2   5
 *           / \
 *          1   3
 * 中序遍历结果：1 2 3 4 5
 *
 */
public class Offer36 {

    Node pre, head;

    public Node treeToDoublyList(Node root) {

        if (root == null) return null;
        // 1 二叉树中序遍历 & 2 形成双向链表
        dfs(root);

        // 3 形成循环链表
        head.left = pre;
        pre.right = head;
        return head;
    }

    // 深度优先的中序遍历
    public void dfs(Node cur) {
        if (cur == null) return;
        // 遍历左子树
        dfs(cur.left);

        // 处理链表的逻辑
        if (pre != null) {
            pre.right = cur;
        } else {
            // 找到头节点
            head = cur;
        }
        cur.left = pre;
        pre = cur;

        // 遍历右子树
        dfs(cur.right);
    }
}
