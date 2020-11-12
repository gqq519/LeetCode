package com.gqq.leetcode.difficulty.easy;

/**
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 *
 * https://leetcode.com/problems/roman-to-integer/description/
 *
 * algorithms
 * Easy (52.13%)1
 * Likes:    1278
 * Dislikes: 2683
 * Total Accepted:    431.9K
 * Total Submissions: 821.5K
 * Testcase Example:  '"III"'
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D
 * and M.
 * 
 * 
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 
 * For example, two is written as II in Roman numeral, just two one's added
 * together. Twelve is written as, XII, which is simply X + II. The number
 * twenty seven is written as XXVII, which is XX + V + II.
 * 
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is
 * written as IV. Because the one is before the five we subtract it making
 * four. The same principle applies to the number nine, which is written as IX.
 * There are six instances where subtraction is used:
 * 
 * 
 * I can be placed before V (5) and X (10) to make 4 and 9. 
 * X can be placed before L (50) and C (100) to make 40 and 90. 
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * 
 * 
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be
 * within the range from 1 to 3999.
 * 
 * Example 1:
 * 
 * 
 * Input: "III"
 * Output: 3
 * 
 * Example 2:
 * 
 * 
 * Input: "IV"
 * Output: 4
 * 
 * Example 3:
 * 
 * 
 * Input: "IX"
 * Output: 9
 * 
 * Example 4:
 * 
 * 
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * 
 * 实现思路：
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 
 * IV            4          IV、IX 相当于是需要减去I所代表的1
 * IX            9
 * 
 * XL            40         XL、XC 相当于是需要减去X所代表的10
 * XC            90
 * 
 * CD            400        CD、CM 相当于是需要减去X所代表的100
 * CM            900
 *
 * 罗列几种字符所代表的不同的数据，进行加减的操作
 * 需要特别注意的是几种组合，是相减的操作。
 * 
 */
class LC013 {
    public int romanToInt(String s) {
        int sum = 0;
        for(int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'I':
                    if(i != s.length() - 1 && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')){
                        sum = sum - 1;
                    }else {
                        sum = sum + 1;
                    }
                    break;
                case 'V':
                    sum = sum + 5;
                    break;
                
                case 'X':
                    if(i != s.length() - 1 && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')){
                        sum = sum - 10;
                    }else {
                        sum = sum + 10;
                    }
                    break;
                
                case 'L':
                    sum = sum + 50;
                    break;
                
                case 'C':
                    if(i != s.length() - 1 && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')){
                        sum = sum - 100;
                    }else {
                        sum = sum + 100;
                    }
                    break;

                case 'D':
                    sum = sum + 500;
                    break;
                
                case 'M':
                    sum = sum + 1000;
                    break;

                default:
                    break;
            }
        }
        return sum;
    }
}

