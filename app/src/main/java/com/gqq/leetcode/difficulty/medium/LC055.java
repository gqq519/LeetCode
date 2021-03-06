package com.gqq.leetcode.difficulty.medium;

import android.icu.util.ULocale;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 10^4
 * 0 <= nums[i][j] <= 10^5
 *
 * https://leetcode-cn.com/problems/jump-game/
 *
 * 解题说明：
 * 通过遍历得到每一个index所能达到的最大距离
 * 根据所能达到的最大距离判断是否是已经到了数组末尾，如果不是，则不可达
 *
 */
public class LC055 {

    public static void main(String[] args) {
        canJump(new int[]{1,2,3});
    }

    public static boolean canJump(int[] nums) {
        if (nums.length == 0) return false;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (max >= nums.length - 1) {
                return true;
            }
            max = Math.max(max, i + num);
            if (max - i == 0 && i != nums.length - 1) {
                return false;
            }
        }
        return false;
    }
}
