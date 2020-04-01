package com.gqq.leetcode.tag.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 *
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.
 *
 * Example 1:
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * Output: [-1,3,-1]
 * Explanation:
 *     For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
 *     For number 1 in the first array, the next greater number for it in the second array is 3.
 *     For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
 * Example 2:
 * Input: nums1 = [2,4], nums2 = [1,2,3,4].
 * Output: [3,-1]
 * Explanation:
 *     For number 2 in the first array, the next greater number for it in the second array is 3.
 *     For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
 * Note:
 * All elements in nums1 and nums2 are unique.
 * The length of both nums1 and nums2 would not exceed 1000.
 *
 * 解法说明
 * 1. 不通过栈来实现，利用双重for循环，依次进行对比，时间复杂度是O(n^2)，比较简单
 *
 * 2. 通过栈来实现，利用栈和Map来实现
 *    1. 入栈：首先将数组依次入栈，入栈时将栈顶和要入栈的数据对比及存入map中，key=栈顶，value=比栈顶大的要入栈的数据
 *    2. 入栈结束后，遍历子数组，从map中找到对应key的value值，默认值-1
 *
 */
public class LC496 {

    public static void main(String[] args) {
        nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
    }

    // 1. 未通过栈来实现，且时间复杂度为O(n^2)
    public static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {

            int currentNum = nums1[i];
            int index = -1;
            int value = -1;

            for (int j = 0; j < nums2.length; j++) {
                if (currentNum == nums2[j]) {
                    index = j;
                } else if (currentNum < nums2[j] && j > index && index != -1) {
                    value = nums2[j];
                    break;
                }
            }
            result[i] = value;
        }

        return result;
    }

    // 2. 利用栈来实现，且控制时间复杂度
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {

            // 入栈时，同时将即将入栈的数据与栈顶数据对比，同时将比栈顶更大的数和栈顶存入map中
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }

}
