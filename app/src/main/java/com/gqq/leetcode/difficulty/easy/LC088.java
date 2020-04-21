package com.gqq.leetcode.difficulty.easy;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * <p>
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * Example:
 * <p>
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * Output: [1,2,2,3,5,6]
 *
 * 解法说明：
 * 利用双向索引，从后向前遍历赋值
 * 因为nums1后面的n个数据都是0，从后向前索引可以在判断之后直接赋值
 *
 */
public class LC088 {

    public static void main(String[] args) {
        merge(new int[]{1, 2, 3, 4, 0, 0, 0}, 4, new int[]{2, 5, 6}, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // nums1中数据的索引
        int j = n - 1; // nums2中数据的索引
        int k = m + n - 1; // nums1总数据的索引

        // 从后向前遍历，循环执行条件
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // 上一个while循环结束一定是因为i/j<0了
        // j<0, 说明nums2遍历完了，i不需要再进行遍历，因为此时nums1的数据已经有序，例如：nums1=[1,2,3,0,0,0] num2=[7,8,9]
        // i<0, 说明nums1中数据遍历完了，nums2中的数据还没遍历完，需要将nums2中数据遍历赋值完，例如：nums1=[7,8,9,0,0,0] nums2=[1,2,3]
        // 体会一下
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
