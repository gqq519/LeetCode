package com.gqq.leetcode.difficulty.easy;

import java.util.HashSet;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Note: nums1 = [1,2], nums2 = [2]
 *
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Note: nums1 = [4,9,5], nums2 = [9,4,8]
 *
 * Each element in the result must be unique.
 * The result can be in any order.
 *
 * 解题思路：
 * 借助Set元素的不重复性实现
 */
public class LC349 {

    public static void main(String[] args) {
        intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> numSet = new HashSet<>();
        HashSet<Integer> resultSet = new HashSet<>();
        // 第一个数组的数据存到Set中
        for (int i = 0; i < nums1.length; i++) {
            numSet.add(nums1[i]);
        }
        // 遍历第二个数组，寻找与第一个数组相同的数据
        for (int i = 0; i < nums2.length; i++) {
            if (numSet.contains(nums2[i])) {
                resultSet.add(nums2[i]);
            }
        }
        // 返回结果数组
        int[] result = new int[resultSet.size()];
        int i = 0;
        for (Integer n : resultSet) {
            result[i++] = n;
        }
        return result;
    }

}
