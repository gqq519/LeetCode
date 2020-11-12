package com.gqq.leetcode.difficulty.easy;

/**
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 *
 * https://leetcode.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (33.36%)
 * Likes:    1302
 * Dislikes: 1272
 * Total Accepted:    449.4K
 * Total Submissions: 1.3M
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * Write a function to find the longest common prefix string amongst an array
 * of strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 * 
 * 
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * 
 * 
 * Note:
 * 
 * All given inputs are in lowercase letters a-z.
 * 
 * solution:
 * https://leetcode.com/problems/longest-common-prefix/solution/
 * 
 * 解题说明：
 * TODO 更优解
 * 
 * 
 */
class LC014 {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        if (strs.length == 0) {
            return result;
        }
        int minSize = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (minSize > strs[i].length()) {
                minSize = strs[i].length();
            }
        }
    
        for (int i = 0; i < minSize; i++) {
            char str = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].charAt(i) == str) {
                    if (j == strs.length -1) {
                        result = result + str;
                        break;
                    }else {
                        continue;
                    }
                }else {
                    return result;
                }
            }
        }
        return result;
    }
}

