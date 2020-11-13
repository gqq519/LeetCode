package com.gqq.leetcode.difficulty.easy;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 *
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 * 解法说明：
 * 动态规划的思想
 * 定义一个current表示最终要返回的结果
 * 定义一个result表示每一轮遍历累加的和的结果
 * 对比current 和 result的结果，取得一个最大值作为最终结果
 * result有一个重制的时机：累加的数据为负数时，需要将当前的结果抛弃掉，因为负数往后累加都会更小
 */
public class LC053 {
    public int maxSubArray(int[] nums) {
        int current = nums[0]; // 最大的和，结果
        int result = 0; //  每次记录的和的结果
        for (int i = 0; i < nums.length; i++) {
            // 计算和以及与当前存储的最大的数据进行对比
            result += nums[i];
            current = Math.max(result, current);

            // 如果累计上当前index的数据之后，result是负的，那么不如不加，从头开始计算，因为负数不管再小，往后加的和都会更小
            if (result < 0) {
                result = 0;
            }
        }
        return current;
    }
}
