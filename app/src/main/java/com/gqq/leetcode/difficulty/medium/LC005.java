package com.gqq.leetcode.difficulty.medium;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * 解题说明：最长回文子串
 * 从字符串某字符为基点，向前/向后遍历对比，找到前后相同的字符最大长度
 * 需要考虑两种情况：回文字符串是偶数长度/奇数长度
 *
 *
 */
public class LC005 {

    public static void main(String[] args) {
        String palindrome = longestPalindrome("babcd");
        System.out.println(palindrome);
    }

    static int point = 0;
    static int maxLength = 0;

    public static String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i+1);
        }
        return s.substring(point, point + maxLength);
    }

    private static void extendPalindrome(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        if (maxLength < end - start - 1) {
            point = start + 1;
            maxLength = end - start - 1;
        }
    }
}
