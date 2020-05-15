package com.gqq.leetcode.difficulty.easy;

import java.util.HashSet;

/**
 * Write an algorithm to determine if a number n is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 *
 * Return True if n is a happy number, and False if not.
 *
 * Example:
 *
 * Input: 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 *
 * 解法说明：
 * 借助结合存储数据
 * 疑难点：循环退出的条件
 * 1 n为1，那么返回true
 * 2 如果计算中没有出现结果1，n重复出现，那么可以说明无限循环，不可能出现1，返回false
 *
 */
public class LC202 {

    public boolean isHappy(int n) {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(n);
        while (true) {
            int next = getNextNum(n);
            if (next == 1) {
                return true;
            }
            if (hashSet.contains(next)) {
                return false;
            }
            hashSet.add(next);
            n = next;
        }
    }

    private int getNextNum(int n) {
        int next = 0;
        while (n > 0) {
            int t = n % 10;
            next += t * t;
            n = n / 10;
        }
        return next;
    }

}
