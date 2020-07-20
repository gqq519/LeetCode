package com.gqq.leetcode.difficulty.easy;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 *
 *
 *
 * Example 1:
 *
 * Input:  00000010100101000001111010011100
 * Output: 00111001011110000010100101000000
 * Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
 * Example 2:
 *
 * Input:  11111111111111111111111111111101
 * Output: 10111111111111111111111111111111
 * Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10111111111111111111111111111111.
 *
 *
 * Note:
 *
 * Note that in some languages such as Java, there is no unsigned integer type. In this case, both input and output will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above the input represents the signed integer -3 and the output represents the signed integer -1073741825.
 *
 *
 * Follow up:
 *
 * If this function is called many times, how would you optimize it?
 *
 * 解法说明：
 * n 不断右移一位 取出每位的数据
 * result 不断左移 不断累加每一位的数据
 * result 如何判断累加的数据是0还是1，通过n & 1的数据，如果n末尾是1，那结果就是1
 *
 */
public class LC190 {

    public static void main(String[] args) {
        reverseBits(100110);
    }

    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            if ((n & 1) == 1) result ++;
            n = n >> 1;
        }
        return result;
    }
}
