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
 * 解法说明：
 * 动态规划
 *
 */
public class LC053 {
    public int maxSubArray(int[] nums) {
        int current = nums[0];
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += nums[i];
            current = Math.max(current, result);
            if (result < 0) {
                result = 0;
            }
        }
        return current;
    }
}
