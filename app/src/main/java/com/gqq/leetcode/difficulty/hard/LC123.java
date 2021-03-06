package com.gqq.leetcode.difficulty.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 * Example 1:
 *
 * Input: [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 *              Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 * Example 2:
 *
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 * 动态规划
 *
 */
public class LC123 {

    public static void main(String[] args) {
        int maxProfit = maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4});
        System.out.println(maxProfit);
    }

    public static int maxProfit(int[] prices) {

        int buyAndSell1 = 0;
        int buyAndSell2 = 0;
        int buy1 = Integer.MAX_VALUE;
        int buy2 = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            int p = prices[i];
            buy1 = Math.min(buy1, p);
            buyAndSell1 = Math.max(buyAndSell1, p - buy1);
            buy2 = Math.min(buy2, p - buyAndSell1);
            buyAndSell2 = Math.max(buyAndSell2, p - buy2);
        }
        return buyAndSell2;
    }
}
