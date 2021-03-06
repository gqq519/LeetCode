package com.gqq.leetcode.difficulty.easy;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 *
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 *
 * 解法说明：
 * 借助一个长度26的数组，分别将s和t中的字符自增和自减，最后判断数组中的数据是否为0
 */
public class LC242 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] data = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            data[sChar - 97] += 1;
            data[tChar - 97] -= 1;
        }
        for (int i = 0; i < data.length; i++) {
            if (data[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
