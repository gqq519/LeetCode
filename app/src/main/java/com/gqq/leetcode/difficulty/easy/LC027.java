package com.gqq.leetcode.difficulty.easy;

/**
 * @lc app=leetcode id=27 lang=java
 * <p>
 * [27] Remove Element
 * <p>
 * https://leetcode.com/problems/remove-element/description/
 * <p>
 * algorithms
 * Easy (44.26%)
 * Likes:    805
 * Dislikes: 1723
 * Total Accepted:    403.8K
 * Total Submissions: 910K
 * Testcase Example:  '[3,2,2,3]\n3'
 * <p>
 * Given an array nums and a value val, remove all instances of that value
 * in-place and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * <p>
 * The order of elements can be changed. It doesn't matter what you leave
 * beyond the new length.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Given nums = [3,2,2,3], val = 3,
 * <p>
 * Your function should return length = 2, with the first two elements of nums
 * being 2.
 * <p>
 * It doesn't matter what you leave beyond the returned length.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Given nums = [0,1,2,2,3,0,4,2], val = 2,
 * <p>
 * Your function should return length = 5, with the first five elements of nums
 * containing 0, 1, 3, 0, and 4.
 * <p>
 * Note that the order of those five elements can be arbitrary.
 * <p>
 * It doesn't matter what values are set beyond the returned length.
 * <p>
 * Clarification:
 * <p>
 * Confused why the returned value is an integer but your answer is an array?
 * <p>
 * Note that the input array is passed in by reference, which means
 * modification to the input array will be known to the caller as well.
 * <p>
 * Internally you can think of this:
 * <p>
 * <p>
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeElement(nums, val);
 * <p>
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len
 * elements.
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 */

/**
 * 解法说明：
 * 1. 设置一个result代表返回的长度，那么result的长度的数组的值一定是除去val值的数据
 * 2. 遍历数组，如果不等于val，那么就将nums[result]置为当前索引i的值，然后result累加1
 *
 *
 */
class LC027 {

    public static void main(String[] args) {
        int result = removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2);
        System.out.println(result);
    }

    public static int removeElement(int[] nums, int val) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[result] = nums[i];
                result++;
            }
        }
        return result;
    }
}

