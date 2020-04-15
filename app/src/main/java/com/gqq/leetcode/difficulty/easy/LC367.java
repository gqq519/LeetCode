package com.gqq.leetcode.difficulty.easy;

/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Note: Do not use any built-in library function such as sqrt.
 *
 * Example 1:
 *
 * Input: 16
 * Output: true
 * Example 2:
 *
 * Input: 14
 * Output: false
 *
 * 解题思路:
 * 借助求平方根的思想，如果是整数，则true否则false
 * mid直接相乘可能会越界，利用除法，需要注意相除之后需要是小数对比
 *
 */
public class LC367 {
    public static void main(String[] args) {
        isPerfectSquare(5);
    }

    public static boolean isPerfectSquare(int num) {
        if (num < 1) return false;
        int low = 1;
        int high = num;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (mid * 1.0f > num * 1.0f / mid) {
                high = mid - 1;
            } else if (mid * 1.0f < num * 1.0f / mid) {
                low = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
