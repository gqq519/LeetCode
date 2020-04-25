package com.gqq.leetcode.difficulty.easy;

import com.gqq.leetcode.TreeNode;
import com.gqq.leetcode.tag.tree.Tree;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 解法说明：
 * 利用二分法构建二叉树
 *
 * 1. 构建平衡二叉查找树，为了符合构建条件，每个节点的值要在给定的范围内取中间值，以保证节点的左子树取值范围都在中间值左范围，右子树取值范围在中间值右范围
 * 2. 利用二分法，构建根节点取整个数组的中间值mid，根节点的left取low-mid-1范围内的中间值，根节点right取mid+1-high范围内的中间值，以此类推。。。
 * 4. 最后递归退出的条件是：构建的节点是叶子节点，即当二分到范围内最后一个数据时 low==high，此时mid在进行+-1递归后，那当前low>high 说明当前节点下没有值了，返回null
 *
 */
public class LC108 {

    public static void main(String[] args) {
        sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        TreeNode root = helper(nums, 0, nums.length - 1);
        return root;
    }

    public static TreeNode helper(int[] num, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = low + ((high - low) >> 1);
        TreeNode node = new TreeNode(num[mid]);
        node.left = helper(num, low, mid - 1);
        node.right = helper(num, mid + 1, high);
        return node;
    }
}
