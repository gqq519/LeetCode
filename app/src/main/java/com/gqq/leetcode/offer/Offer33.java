package com.gqq.leetcode.offer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 *  
 *
 * 参考以下这颗二叉搜索树：
 *
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 * 示例 1：
 *
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 *
 * 输入: [1,3,2,6,5]
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
 *
 * 解题说明：
 *
 */
public class Offer33 {

    public static void main(String[] args) {
        boolean postorder = verifyPostorder(new int[]{1, 3, 2, 6, 5});
        System.out.println(postorder);
    }

    public static boolean verifyPostorder(int[] postorder) {
        return verify(postorder, 0, postorder.length - 1);
    }

    public static boolean verify(int[] postorder, int i, int j) {
        if (i >= j) return true;
        int p = i;
        // 判定根节点的左子树的区间：左子树都小于根节点
        while (postorder[p] < postorder[j]) {
            p++;
        }
        int m = p; // 记录左右子树分割的区间点
        // 遍历数组剩余数据，为了保证左子树都比根节点小，右子树都比根节点大，如果不是，那么肯定不是平衡二叉树
        while (postorder[p] > postorder[j]) {
            p++;
        }
        // 判断数组是否遍历结束，并且再递归判断左右子树
        return p == j && verify(postorder, i, m - 1) && verify(postorder, m, j - 1);
    }
}
