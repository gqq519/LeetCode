package com.gqq.leetcode.difficulty.easy;

/**
 * @lc app=leetcode id=9 lang=java
 *
 * [9] Palindrome Number
 *
 * https://leetcode.com/problems/palindrome-number/description/
 *
 * algorithms
 * Easy (42.93%)
 * Likes:    1383
 * Dislikes: 1282
 * Total Accepted:    569.7K
 * Total Submissions: 1.3M
 * Testcase Example:  '121'
 *
 * Determine whether an integer is a palindrome. An integer is a palindrome
 * when it reads the same backward as forward.
 *
 * Example 1:
 *
 *
 * Input: 121
 * Output: true
 *
 *
 * Example 2:
 *
 *
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it
 * becomes 121-. Therefore it is not a palindrome.
 *
 *
 * Example 3:
 *
 *
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a
 * palindrome.
 *
 *
 * Follow up:
 *
 * Coud you solve it without converting the integer to a string?
 *
 * 解题说明：不借助转换为string的方式
 * 1、负数及末尾为0的数据不是，首先要排除掉
 * 2、将x不断取余后得到反转的数据，直到x小于/等于reverse
 *    x         everse     x之后
 *   12321      1          1232
 *   1232       12         123
 *   123        123        12
 *   x 小于 reverse了，不再进行下一步
 *
 * 3、然后判断 x 和revse是否符合回文的规则：x == reverse（x偶数） 或者 x == reverse / 10 （x奇数）
 *
 */

class LC009 {
    public boolean isPalindrome(int x) {
        if(x == 0) return true;
        if(x < 0 || x % 10 == 0) return false;
        int reverse = 0;
        while(x > reverse) {
            if(reverse * 10 + x % 10 > Integer.MAX_VALUE) return false;
            reverse = reverse * 10 + x % 10;
            x = x / 10;
        }
        return (x == reverse) || (reverse / 10 == x);
    }
}

