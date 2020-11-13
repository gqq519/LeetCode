package com.gqq.leetcode.difficulty.medium;

/**
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 *
 * Example 1:
 *
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 *
 * Input: 2.10000, 3
 * Output: 9.26100
 * Example 3:
 *
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * Note:
 *
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−231, 231 − 1]
 *
 *
 * 解题说明：
 * 两种方式：快速幂+递归、快速幂+分治
 *
 *
 * 1、快速幂+递归的方式
 *
 * 2^10 = 2^5 * 2^5
 * 2^5 = 2^2 * 2^2 * 2
 * 2^2 = 2 * 2
 *
 *
 * 2、快速幂+分治的方式
 *
 * 2^10 = (2^5)^2
 *
 *
 *  n      2         4             8            16
 * res = 2(*2) -> 2^2(*2^2) -> 2^4(*2^4) -> 2^8(* 2^8)
 *
 * 如果n为奇数，那么乘数的系数需要额外加 *x
 *
 */
public class LC050 {
    public static void main(String[] args) {
        myPow2(2.00000, 3);
    }


    // 1、递归的方式
    public double myPow1(double x, int n) {
        // 0的n次幂为1
        if (n == 0) return 1;
        long N = n;

        // 判断n是正负，2^-10 = 1/ 2^10
        return N > 0 ? quick1(x, N) : 1 / quick1(x, -N);
    }

    private double quick1(double x, long n) {
        // 递归退出的条件
        if (n == 0) return 1.0;
        // 递归获取n / 2的结果：2^10 = 2^5 * 2^5，2^11 = 2^5 * 2^5 * 2 那么只需要获取出来2^5 就可以了
        double y = quick1(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }




    // 2、分治的方式
    public static double myPow2(double x, int n) {
        if (n == 0) return 1;
        long N = n;
        // 判断n是正负，2^-10 = 1/ 2^10
        return N > 0 ? quick2(x, N) : 1 / quick2(x, -N);
    }

    private static double quick2(double x, long n) {
        double res = 1.0;
        double tmpX = x;
        while (n > 0) {
            if (n % 2 == 1) {
                res *= tmpX;
            }
            tmpX *= tmpX;
            n = n / 2;
        }
        return res;
    }
}
