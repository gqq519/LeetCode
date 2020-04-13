package com.gqq.leetcode.difficulty.easy;

/**
 * Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
 *
 * Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
 *
 * You may return any answer array that satisfies this condition.
 *
 *
 *
 * Example 1:
 *
 * Input: [4,2,5,7]
 * Output: [4,5,2,7]
 * Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
 *
 *
 * Note:
 *
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 *
 * 解法说明：
 * 需要得到的结果是[偶,奇,偶,奇,偶,奇]
 *
 * 1. 遍历数组，新建一个数组用于存放遍历的结果，根据奇偶添加到合适的位置。
 * 2. 遍历数据，原地交换奇偶数。
 *
 */
public class LC922 {

    public static void main(String[] args) {
        sortArrayByParityII2(new int[]{4, 2, 5, 7});
    }

    // 时间复杂度：O(n)，空间复杂度：O(n)
    public static int[] sortArrayByParityII(int[] A) {
        int[] result = new int[A.length];

        int t = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                result[t] = A[i];
                t += 2;
            }
        }
        t = 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 != 0) {
                result[t] = A[i];
                t += 2;
            }
        }
        return result;
    }

    // 更优
    // 时间复杂度：O(n)，空间复杂度：O(1)
    public static int[] sortArrayByParityII2(int[] A) {
        int j = 1;
        for (int i = 0; i < A.length; i += 2) {
            // i 都是偶数

            // 判断是不是偶数，如果不是，找到下一个偶数，交换
            if (A[i] % 2 == 1) {
                // 查找奇数
                while (A[j] % 2 == 1) {
                    j += 2;
                }

                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
        return A;
    }

}
