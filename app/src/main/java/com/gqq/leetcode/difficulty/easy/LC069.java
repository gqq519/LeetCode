package com.gqq.leetcode.difficulty.easy;

/**
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 *
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 *
 * Example 1:
 *
 * Input: 4
 * Output: 2
 * Example 2:
 *
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 * the decimal part is truncated, 2 is returned.
 *
 * 解题思路：
 * 求平方根
 * 利用二分查找的方法：
 * 1. x = 1 return 1;
 * 2. x < 1 return 0;
 * 3. 1 < result < x , 界定条件: result^2 大于x且 result+1^2 小于X
 * 注意：警惕超出int范围：result*result > x ---->  result > x/result
 */
public class LC069 {
    public static void main(String[] args) {

        int sqrt = mySqrt(2147395599);
        System.out.println(sqrt);
    }

    public static int mySqrt(int x) {
        if (x == 1) return 1;
        if (x < 1) return 0;
        int low = 1;
        int high = x;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (mid > x / mid) {
                if ((mid - 1) < x / (mid - 1)) {
                    return mid - 1;
                } else {
                    high = mid - 1;
                }
            } else if (mid < x / mid) {
                if ((mid + 1) > x / (mid + 1)) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else {
                return mid;
            }
        }
        return 1;
    }
}

