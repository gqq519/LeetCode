package com.gqq.leetcode.difficulty.easy;

import java.util.HashMap;
import java.util.Stack;

/**
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 *
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (36.33%)
 * Likes:    2802
 * Dislikes: 138
 * Total Accepted:    569.9K
 * Total Submissions: 1.6M
 * Testcase Example:  '"()"'
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 *
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 *
 * Input: "()"
 * Output: true
 *
 *
 * Example 2:
 *
 *
 * Input: "()[]{}"
 * Output: true
 *
 *
 * Example 3:
 *
 *
 * Input: "(]"
 * Output: false
 *
 *
 * Example 4:
 *
 *
 * Input: "([)]"
 * Output: false
 *
 *
 * Example 5:
 *
 *
 * Input: "{[]}"
 * Output: true
 *
 *
 *
 * 解题说明：
 * 借助Stack的入栈和出栈思想实现。
 * 将配对的()[]{}分别存储为key和value，遍历的时候根据当前的字符进行选择入栈或出栈的操作
 *
 */

public class LC020 {

    public static void main(String[] args) {
        System.out.print(isValid("{]}"));
    }

    public static boolean isValid(String s) {

        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        if (s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char str = s.charAt(i);

            // 如果是属于key，那么需要处理看是否在当前的栈顶是对应的闭合符号
            if (map.containsKey(str)) {
                // 处理弹出
                char topEle = stack.peek();
                if (stack.empty()) {
                    return false;
                } else {
                    if (topEle == map.get(str)) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }

            } else {
                // 是value，开的符合，存入到Stack中
                stack.push(str);
            }
        }
        return stack.empty();
    }

}
