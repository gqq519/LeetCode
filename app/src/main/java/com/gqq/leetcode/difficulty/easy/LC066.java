package com.gqq.leetcode.difficulty.easy;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 *
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 *
 * 题目解析：输入的数组可以当作一个整数，将整数+1，得到新的数组，
 *         需要特别注意的是含有9的数据/全部都是9的数据
 * 例如：[1,2,3] ---> 123 + 1 = 124 ---> [1,2,4]
 *      [1,2,4] ---> 124 + 1 = 125 ---> [1,2,5]
 *      [1,2,9] ---> 129 + 1 = 130 ---> [1,3,0]
 *      [9,9,9] ---> 999 + 1 = 1000 ---> [1,0,0,0]
 *
 * 解法说明：
 * 数组从后向前遍历，
 * 1. 如果末尾不是9，则+1，直接return掉
 * 2. 如果末尾是9，那么该位置+1之后就是0，需要向前进一位，所以不return，继续遍历到下一个继续+1
 * 3. 循环内return的话，说明不全为9，正确处理了+1结束
 * 4. 循环内未return，说明全部为9，+1LC 之后变成100...00 的数据，原有数组长度+1，[0]为1，其余为0
 *
 */
public class LC066 {
    public static void main(String[] args) {
        plusOne(new int[]{9, 9, 9, 9});
    }

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] ++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[n+1];
        result[0] = 1;
        return result;
    }
}
