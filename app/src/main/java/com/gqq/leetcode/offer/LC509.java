package com.gqq.leetcode.offer;

/**
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), for N > 1.
 * Given N, calculate F(N).
 *
 * Example 1:
 *
 * Input: 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 * Example 2:
 *
 * Input: 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 * Example 3:
 *
 * Input: 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 *
 *
 * Note:
 *
 * 0 ≤ N ≤ 30.
 *
 * 解法说明：斐波那契数列  f(n) = f(n - 1) + f(n - 2)
 *
 * 递归的方式不推荐使用，会产生很多重重复数据的计算
 *
 * 推荐：线性累加
 *
 * 0    1   1 ....
 * one  two fn
 *
 * 0    1   1   2
 *      onw two fn
 *
 * 0    1   1   2   3
 *          onw two fn
 * .....
 *
 * 得到fn
 */
public class LC509 {
    public int fib(int N) {
        if (N == 0) return 0;
        if (N == 1) return 0;
        if (N == 2) return 1;
        int one = 0, two = 1, fn = 0;
        for (int i = 3; i <= N; i++) {
            fn = one + two;
            one = two;
            two = fn;
        }
        return fn;
    }
}
