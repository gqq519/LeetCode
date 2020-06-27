package com.gqq.leetcode.difficulty.hard;

import com.gqq.leetcode.ListNode;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 *
 * Follow up:
 * Could you solve it in linear time?
 *
 * Example:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 *
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 */
public class LC239 {
    public static void main(String[] args) {

        int []a = maxSlidingWindow(new int[]{1,-1,-2},2);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }


    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length <= 0) return null;
        int[] res = new int[nums.length - k + 1];
        int max = nums[0];
        int resPoint = 0;
        int point = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (point == k - 1) {
                if (i - k >= 0 && max == nums[i - k]) {
                    point = 0;
                    i = i - point;
                    max = nums[i];
                } else {
                    res[resPoint] = max;
                    point--;
                    resPoint++;
                }

            }
            point++;

        }

        return res;
    }
}
