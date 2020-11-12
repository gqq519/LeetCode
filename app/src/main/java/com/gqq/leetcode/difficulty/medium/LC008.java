package com.gqq.leetcode.difficulty.medium;

/**
 * Implement atoi which converts a string to an integer.
 *
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned.
 *
 * Note:
 *
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 * Example 1:
 *
 * Input: "42"
 * Output: 42
 * Example 2:
 *
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 *              Then take as many numerical digits as possible, which gets 42.
 * Example 3:
 *
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 * Example 4:
 *
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 *              digit or a +/- sign. Therefore no valid conversion could be performed.
 * Example 5:
 *
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 *              Thefore INT_MIN (−231) is returned.
 *
 *
 * 解题说明：
 * 1、首先通过StringBuilder累计得到一个符合规则后的字符串
 * 2、字符串转换为long，判断是否超过了Int的最大和最小值，返回正确的数据
 *
 */
public class LC008 {

    public static void main(String[] args) {
        int myAtoi = myAtoi("  0000000000012345678");
        System.out.println(myAtoi);
    }

    public static int myAtoi(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        Boolean is =false;
        str = str.trim();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ((ch == '-' && i == 0) || Character.isDigit(ch)) {
                stringBuilder.append(ch);
            } else if (ch == '+' && i == 0) {
                continue;
            } else {
                break;
            }
        }
        String string = stringBuilder.toString();
        if (string.equals("") || string.equals("-")) return 0;

        if (string.length()<12){
            long parseLong = Long.parseLong(string);
            if (parseLong > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (parseLong < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            } else {
                return (int) parseLong;
            }

        }else {
            if (string.contains("-")){
                return Integer.MIN_VALUE;
            }else {
                return Integer.MAX_VALUE;
            }

        }
    }
}
