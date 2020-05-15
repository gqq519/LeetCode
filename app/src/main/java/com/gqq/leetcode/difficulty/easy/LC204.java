package com.gqq.leetcode.difficulty.easy;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * Example:
 *
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
public class LC204 {

    // 效率太低了
    public int countPrimes(int n) {
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimes(i)) {
                res += 1;
            }
        }
        return res;
    }

    //
    public int countPrimes1(int n) {
        boolean[] notPrimes = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrimes[i]) {
                count++;
                for (int j = 2; j * i < n; j++) {
                    notPrimes[i * j] = true;
                }
            }
        }
        return count;
    }

    private boolean isPrimes(int i) {

        if (i < 2) {
            return true;
        }

        int sqrt = (int) Math.sqrt(i);

        for (int j = 2; j <= sqrt; j++) {
            if (i % j == 0) {
                return false;
            }
        }

        return true;
    }
}
