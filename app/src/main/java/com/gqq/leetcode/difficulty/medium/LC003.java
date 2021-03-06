package com.gqq.leetcode.difficulty.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * 解题说明：
 * 借助双重for循环和List
 * 第一层for循环：从哪里开始截取的子串长度最大
 * 第二层for循环：从其实位置往后查找最大的子串
 *
 */
public class LC003 {

    public static void main(String[] args) {
        int substring = lengthOfLongestSubstring(" ");
        System.out.println(substring);
    }

    public static int lengthOfLongestSubstring(String s) {

        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) {
                    break;
                } else {
                    set.add(s.charAt(j));
                }
            }
            count = Math.max(count, set.size());
        }
        return count;
    }

}
