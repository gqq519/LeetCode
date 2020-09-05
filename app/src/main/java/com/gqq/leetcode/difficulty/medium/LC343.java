package com.gqq.leetcode.difficulty.medium;

/**
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
 *
 * Example 1:
 *
 * Input: 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 * Example 2:
 *
 * Input: 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 * Note: You may assume that n is not less than 2 and not larger than 58.
 *
 *
 * 解题说明：剪绳子问题
 * n    最大值组合
 * 2    1*1
 * 3    1*2
 * 4    2*2
 * 5    3*2
 * 6    3*3
 * 7    3*4/3*2*2
 * 8    3*3*2
 * 9    3*3*3
 * 10   3*3*4
 * .....
 * 19   3*3*3*3*3*4
 *
 * 总结规律所得：
 * n=2  1
 * n=3  2
 * n=4  4
 * n>4  尽可能的分解出更多的3
 * 临界点4：不分解为3*1 是因为 2*2>3*1
 *
 */
public class LC343 {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int result = 1;
        while (n > 4) {
            result *= 3;
            n -= 3;
        }
        result *= n;
        return result;
    }
}
