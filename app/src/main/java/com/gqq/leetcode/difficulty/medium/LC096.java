package com.gqq.leetcode.difficulty.medium;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Example:
 *
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * 解法说明：https://leetcode.com/problems/unique-binary-search-trees/discuss/31666/DP-Solution-in-6-lines-with-explanation.-F(i-n)-G(i-1)-*-G(n-i)
 *
 */
public class LC096 {

    public static void main(String[] args) {
        numTrees(3);
    }

    // 参考解答
    public static int numTrees2(int n) {
        int [] G = new int[n+1];
        G[0] = G[1] = 1;

        for(int i=2; i<=n; ++i) {
            for(int j=1; j<=i; ++j) {
                G[i] += G[j-1] * G[i-j];
            }
        }
        return G[n];
    }

    // 利用递归的方式，非常耗时
    public static int numTrees(int n) {
        if (n == 0) return 0;
        return getTrees(1, n);
    }

    private static int getTrees(int start, int end) {
        int res = 0;
        if (start >= end) {
            res += 1;
            return res;
        }
        for (int i = start; i <= end ; i++) {
            int leftSize = getTrees(start, i - 1);
            int rightSize = getTrees(i + 1, end);
            res += leftSize * rightSize;
        }
        return res;
    }
}
