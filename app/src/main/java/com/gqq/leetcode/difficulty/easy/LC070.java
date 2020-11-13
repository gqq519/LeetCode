package com.gqq.leetcode.difficulty.easy;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 *
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 * https://leetcode-cn.com/problems/climbing-stairs/
 *
 * 解题说明：斐波那契算法
 * 斐波那契的几种算法实现：
 * 1、递归：通过f(n) = f(n - 1) + f(n - 2)计算，会导致很多重复的计算数据，以及递归层级很深，可能会堆栈溢出，不推荐
 * 2、递推：通过f(n - 1) 和 f(n - 2) 推出 f(n)
 * 3、矩阵
 *
 *
 */
public class LC070 {

    public static void main(String[] args) {
        int climbStairs = climbStairs2(45);
        System.out.println(climbStairs);
    }

    // 递归的方式
    public static int climbStairs(int n) {
        return climb_Stairs(0, n);
    }

    public static int climb_Stairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }

    // 递推的方式
    public static int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
