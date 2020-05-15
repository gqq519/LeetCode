package com.gqq.leetcode.difficulty.easy;

import java.util.HashMap;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 *
 * 解法说明：
 * 借助集合框架
 *
 */
public class LC136 {
    public int singleNumber(int[] nums) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                hashMap.remove(nums[i]);
            } else {
                hashMap.put(nums[i], i);
            }
        }
        int res = 0;
        for (Integer integer:hashMap.keySet()) {
            res = integer;
        }
        return res;

    }
}
