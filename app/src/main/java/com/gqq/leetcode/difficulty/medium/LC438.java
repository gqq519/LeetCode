package com.gqq.leetcode.difficulty.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 *
 * The order of output does not matter.
 *
 * Example 1:
 *
 * Input:
 * s: "cbaebabacd" p: "abc"
 *
 * Output:
 * [0, 6]
 *
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 *
 * Input:
 * s: "abab" p: "ab"
 *
 * Output:
 * [0, 1, 2]
 *
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 */
public class LC438 {

    public static void main(String[] args) {
        findAnagrams("ceaebabacd", "abc");
    }

    public static List<Integer> findAnagrams(String s, String p) {

//        效率太低
//        List<Integer> result = new ArrayList<>();
//        char[] charArray = p.toCharArray();
//        Arrays.sort(charArray);
//        for (int i = 0; i < s.length() - p.length() + 1; i++) {
//            char[] chars = s.substring(i, i + p.length()).toCharArray();
//            Arrays.sort(chars);
//            if (String.valueOf(charArray).equals(String.valueOf(chars))) {
//                result.add(i);
//            }
//        }
//        return result;


        List<Integer> list = new ArrayList<>();
        int[] hash = new int[256];
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            if (hash[s.charAt(right)] >= 1) {
                count--;
            }
            hash[s.charAt(right)]--;
            right++;
            if (count == 0) {
                list.add(left);
            }

            if (right - left == p.length()) {
                if (hash[s.charAt(left)] >= 0) {
                    count++;
                }
                hash[s.charAt(left)]++;
                left++;
            }
        }
        return list;
    }

}
