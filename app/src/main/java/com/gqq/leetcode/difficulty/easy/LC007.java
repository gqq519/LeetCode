package com.gqq.leetcode.difficulty.easy;

/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 *
 * https://leetcode.com/problems/reverse-integer/description/
 *
 * algorithms
 * Easy (25.26%)
 * Likes:    2116
 * Dislikes: 3210
 * Total Accepted:    679.2K
 * Total Submissions: 2.7M
 * Testcase Example:  '123'
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 *
 * Input: 123
 * Output: 321
 *
 *
 * Example 2:
 *
 *
 * Input: -123
 * Output: -321
 *
 *
 * Example 3:
 *
 *
 * Input: 120
 * Output: 21
 *
 *
 * Note:
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose
 * of this problem, assume that your function returns 0 when the reversed
 * integer overflows.
 *
 * thought：
 * 取余 求整
 * 123
 * 1. 123 % 10 = 3   123 / 10 = 12  3
 * 2. 12 %  10 = 2   3 * 10 + 2 = 32
 * 3. 1 % 10   = 1   32 * 10 + 1 = 321
 *
 * -123
 *
 */
class LC007 {
    public int reverse(int x) {
        long res = 0;
        int pre = 0;
        while (true) {
            if (x == 0) break;
            pre = x % 10;
            if (res * 10 + pre > Integer.MAX_VALUE || res * 10 + pre < Integer.MIN_VALUE) {
                return 0;
            }
            res = res * 10 + pre;
            x = x / 10;
        }
        return (int) res;
    }
}
