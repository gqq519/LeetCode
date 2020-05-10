package com.gqq.leetcode.difficulty.easy;

/**
 * Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 *
 * Constraints:
 *
 * Each string consists only of '0' or '1' characters.
 * 1 <= a.length, b.length <= 10^4
 * Each string is either "0" or doesn't contain any leading zero.
 */
public class LC067 {
    public String addBinary(String a, String b) {

        int aPoint = a.length() - 1;
        int bPoint = b.length() - 1;
        int last = 0;
        StringBuilder builder = new StringBuilder();
        while (aPoint >= 0 || bPoint >= 0) {
            int sum = last;
            if (bPoint >= 0) sum += b.charAt(bPoint--) - '0';
            if (aPoint >= 0) sum += a.charAt(aPoint--) - '0';
            builder.append(sum % 2);
            last = sum / 2;
        }
        if (last != 0) {
            builder.append(last);
        }
        return builder.reverse().toString();
    }
}
