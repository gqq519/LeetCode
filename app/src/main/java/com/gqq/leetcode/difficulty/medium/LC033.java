package com.gqq.leetcode.difficulty.medium;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 * 解题思路：
 * 1 首先遍历数组，找到最小值所在的位置：注意边界条件的判断：循环退出的条件low<high，low和high的变化
 * 2 找到最小值的索引后，确定进行二分查找时的坐标范围
 *
 */
public class LC033 {

    public static void main(String[] args) {
        search(new int[]{3, 5, 1}, 5);
    }

    public static int search(int[] nums, int target) {
        if (nums.length < 1) return -1;
        int low = 0;
        int high = nums.length - 1;

        // 先遍历出最小值的坐标：注意边界条件
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        // 确定low和high的坐标范围开始遍历: 注意先赋值high，或者防止出错，再定义一个变量存储找到的最小值索引
        if (target == nums[low]) return low;
        high = (target > nums[nums.length - 1]) ? low : nums.length - 1;
        low = (target <= nums[nums.length - 1]) ? low : 0;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
