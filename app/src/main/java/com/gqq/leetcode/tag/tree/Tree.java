package com.gqq.leetcode.tag.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 树：
 *  高度：节点到叶子结点最长路径
 *  深度：根结点到此节点所经历的边数
 *  层：  节点深度+1
 *
 * 二叉树：
 *  满二叉树：除叶子节点外，每个节点都有左右节点
 *  完全二叉树：叶子节点都在最下面两层，且都靠左排列，并且除了最后一层，其他层的节点数达到最大
 *  这种分类的主要是存储方式的原因
 *
 * 存储方式：
 *  链表存储：双向链表
 *  顺序存储：数组，根节点存储在i=1的位置上，那么节点所在的数组的位置就是左节点：2*i，右节点：2*i+1
 *
 * 二叉树的遍历：
 *  前序遍历：节点 - 左子节点 - 右子节点
 *  中序遍历：左子节点 - 节点 - 右子节点
 *  后续遍历：左子节点 - 右子节点 - 节点
 *  遍历的时间复杂度：O(n)
 *
 * 二叉查找树/二叉搜索树
 *  二叉查找树要求，在树中的任意一个节点，其左子树中的每个节点的值，都要小于这个节点的值，而右子树节点的值都大于这个节点的值。
 *  按照中序遍历的方式，会得到一个有序数组。

 *  查找操作：
 *      鉴于二叉查找树的特点，取根节点，小于向左子树查找，大于向右子树查找
 *  插入操作：根据他的特点，插入到左节点还是右节点
 *  删除操作：删除操作需要考虑几种情况
 *      1. 删除的节点没有左右节点，那么直接删除，然后父节点指向空即可
 *      2. 删除的节点只有一个节点，直接删除，然后父节点指向删除节点的子节点
 *      3. 删除的节点有两个节点，遍历出删除节点右子树的最小节点替换到删除节点的位置，然后再删除最小节点
 *
 *  支持重复数据的二叉查找树：
 *      1. 每个节点不直接存储数据，而是存储链表或支持动态扩容的数组，用于存放值相同的数据
 *      2. 相同的节点可以存储在右子树，当作大于的情况： 查找、删除的时候会稍麻烦，遍历到第一个数之后还需要继续遍历，删除就是依次删除。
 *
 *  时间复杂度：
 *      最差情况(退化为链表)O(n), 完全二叉树O(logn)
 *      时间复杂度其实都跟树的高度成正比，也就是 O(height)。
 *
 * 平衡二叉查找树：
 *  红黑树：由2-3树发展而来，资料：https://www.cnblogs.com/tiancai/p/9072813.html
 *
 */
public class Tree {

    private static Node tree;

    public static void main(String[] args) {
        // 模拟Tree
        Node tree = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        tree.left = node2;
        tree.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

//        printNode(tree);
        levelOrder(tree);
    }

    // 树的遍历：
    public static void printNode(Node tree) {
        if (tree == null) return;
        // 前序遍历
        System.out.print(tree.data);
        printNode(tree.left);
        printNode(tree.right);

        // 中序遍历
        printNode(tree.left);
        System.out.print(tree.data);
        printNode(tree.right);

        // 后序遍历
        printNode(tree.left);
        printNode(tree.right);
        System.out.print(tree.data);
    }

    // 层序遍历
    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            System.out.print(currentNode.data + " ");
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }

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

    // 删除节点
    public static void deleteNode(int data) {
        // 首先遍历节点，找到需要删除的节点
        Node p = tree; // 遍历的节点
        Node pp = null; // 遍历节点的父节点

        // 遍历出需要删除的节点: p.val != data的条件主要是为了父节点的正确赋值
        while (p != null && p.data != data) {
            pp = p;
            if (data > p.data) {
                p = p.right;
            } else if (data < p.data) {
                p = p.left;
            }
        }
        if (p == null) {
            return;
        }

        // 删除
        // 1. 删除的节点有两个子节点
        if (p.left != null && p.right != null) {
            Node minP = p.right;
            Node minPP = p;
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            // 替换minP的数据到p中，然后就变成删除minP了，此时删除minP可以利用删除节点的两外两种情况
            p.data = minP.data;
            p = minP;
            pp = minPP;
        }

        // 2. 删除的节点没有或者只有一个节点
        Node child;
        if (p.left == null && p.right == null) {
            child = null;
        } else if (p.left == null) {
            // 右节点
            child = p.right;
        } else {
            // 左节点
            child = p.left;
        }
        if (pp == null) {
            tree = child;
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }

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
