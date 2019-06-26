package com.gqq.leetcode.difficulty.easy;

import java.util.HashMap;

/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 *
 * https://leetcode.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (43.62%)
 * Likes:    10517
 * Dislikes: 348
 * Total Accepted:    1.7M
 * Total Submissions: 3.9M
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 *
 * Example:
 *
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 *
 *
 *
 */
class LC001 {
    public int[] twoSum(int[] nums, int target) {

        int[] array = new int[2];
        if (nums == null || nums.length <= 1) {
            return array;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            int a = target - nums[i];
            if (map.containsKey(a)) {
                array[0] = map.get(a);
                array[1] = i;
            } else {
                map.put(nums[i], i);
            }
        }
        return array;
    }
}

