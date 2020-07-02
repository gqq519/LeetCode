package com.gqq.leetcode.difficulty.hard;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Example:
 *
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 *     Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */
public class LC045 {

    public static void main(String[] args) {
        jump(new int[]{2,3,1,1,4});
    }

    public static int jump(int[] nums) {
//        int jump = 0, curEnd = 0, curFast = 0;
//        for (int i = 0; i < nums.length; i++) {
//            curFast = Math.max(curFast, i + nums[i]);
//            if (i == curEnd) {
//                if (curEnd >= nums.length - 1) {
//                    break;
//                }
//
//                jump++;
//                curEnd = curFast;
//
//            }
//        }
//        return jump;

        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }

}
