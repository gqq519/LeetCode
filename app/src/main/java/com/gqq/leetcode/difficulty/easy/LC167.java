package com.gqq.leetcode.difficulty.easy;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 *
 * Note:
 *
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * Example:
 *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 *
 * Example 2:
 *
 * Input: numbers = [2,2,7,7,11,15], target = 9
 * Output: [1,4]
 *
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 *
 * 返回数组中和为目标值的索引位置，经测试，如果含有重复数据返回的是第一和最后一个，比如example 2
 *
 * 解题思路：
 * 定义两个指针前后索引low = 0; high = numbers,length - 1
 * 1. 定义循环的范围是low <= high, 因为是两个数相加，所以等于的条件也可以不要
 * 2. 中断条件：数据遍历结束low > high 或者 遍历中找到了目标数据和
 * 3. 循环结束后low和high是目标数据索引，+1返回。
 */
public class LC167 {
    public static void main(String[] args) {
        twoSum(new int[]{2, 2, 7, 7, 11, 15}, 9);
    }

    public static int[] twoSum(int[] numbers, int target) {

        int[] result = new int[2];

        int low = 0;
        int high = numbers.length - 1;

        while (low <= high) {
            if (numbers[low] + numbers[high] > target) {
                high --;
            } else if (numbers[low] + numbers[high] < target) {
                low ++;
            } else {
                break;
            }
        }
        result[0] = low + 1;
        result[1] = high + 1;
        return result;
    }
}
