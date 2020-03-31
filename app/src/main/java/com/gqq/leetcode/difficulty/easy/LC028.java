package com.gqq.leetcode.difficulty.easy;

/**
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Implement strStr()
 *
 * https://leetcode.com/problems/implement-strstr/description/
 *
 * algorithms
 * Easy (31.78%)
 * Likes:    851
 * Dislikes: 1271
 * Total Accepted:    419.9K
 * Total Submissions: 1.3M
 * Testcase Example:  '"hello"\n"ll"'
 *
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 *
 * Example 1:
 *
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 *
 *
 * Example 2:
 *
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 *
 *
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great
 * question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty
 * string. This is consistent to C's strstr() and Java's indexOf().
 *
 * 主要借助substring的截取功能
 *
 */
class LC028 {

    public static void main(String[] args) {

    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (!haystack.contains(needle)) return -1;
        for (int i = 0; i < haystack.length(); i++) {
            if (needle.length() + i > haystack.length()) {
                return -1;
            } else if (haystack.substring(i, needle.length() + i).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}

