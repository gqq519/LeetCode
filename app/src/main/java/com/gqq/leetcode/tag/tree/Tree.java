package com.gqq.leetcode.tag.tree;

import org.w3c.dom.Node;

/**
 * 树：
 * 高度：节点到叶子结点最长路径
 * 深度：根结点到此节点所经历的边数
 * 层：  节点深度+1
 *
 * 二叉树：
 * 满二叉树：除叶子节点外，每个节点都有左右节点
 * 完全二叉树：叶子节点都在最下面两层，且都靠左排列，并且除了最后一层，其他层的节点数达到最大
 * 这种分类的主要是存储方式的原因
 *
 * 存储方式：
 * 链表存储：双向链表
 * 顺序存储：数组，根节点存储在i=1的位置上，那么节点所在的数组的位置就是左节点：2*i，右节点：2*i+1
 *
 * 二叉树的遍历：
 * 前序遍历：节点 - 左子节点 - 右子节点
 * 中序遍历：左子节点 - 节点 - 右子节点
 * 后续遍历：左子节点 - 右子节点 - 节点
 * 遍历的时间复杂度：O(n)
 *
 * 二叉查找树/二叉搜索树
 * 二叉查找树要求，在树中的任意一个节点，其左子树中的每个节点的值，都要小于这个节点的值，而右子树节点的值都大于这个节点的值。
 *
 * 查找操作：
 *  鉴于二叉查找树的特点，取根节点，小于向左子树查找，大于向右子树查找
 *  插入操作：根据他的特点，插入到左节点还是右节点
 *  删除操作：删除操作需要考虑几种情况
 *      1. 删除的节点没有左右节点，那么直接删除，然后父节点指向空即可
 *      2. 删除的节点只有一个节点，直接删除，然后父节点指向删除节点的子节点
 *      3. 删除的节点有两个节点，遍历出删除节点右子树的最小节点替换到删除节点的位置，然后再删除最小节点
 */
public class Tree {

    private static Node tree;

    // 二叉树的查找操作
    public static Node findNode(int data) {
        Node p = tree;
        while (p != null) {
            if (data > p.data) {
                p = p.right;
            } else if (data < p.data) {
                p = p.left;
            } else {
                return p;
            }
        }
        return null;
    }

    // 二叉树的插入操作
    public static void insertNode(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }
        Node p = tree;
        while (p != null) {
            if (data > p.data) {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else {
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    public static void deleteNode(int data) {

    }

    // 节点
    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }


}
