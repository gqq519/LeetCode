package com.gqq.leetcode.tag.sort;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class LC215 {
    public static void main(String[] args) {
        int kthLargest = findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4);
        System.out.println(kthLargest);
    }

    public static int findKthLargest(int[] nums, int k) {
        // 可以先将数组进行排序：利用快排
        sort(nums, 0, nums.length - 1);
        return nums[nums.length - k];

    }

    public static void sort(int[] nums, int begin, int end) {
        // 遍历结束
        if (begin > end) {
            return;
        }

        // 将数组的第一个数据作为基准点
        int tmp = nums[begin];
        // i 从头向后索引
        int i = begin;
        // j 从尾向前索引
        int j = end;

        // i 和 j 未相遇
        while (i != j) {

            // 从后向前寻找小于基准点的数据
            while (nums[j] >= tmp && j > i) {
                j--;
            }

            // 从前向后寻找大于基准点的数据
            while (nums[i] <= tmp && j > i) {
                i++;
            }

            // 交换大于/小于基准点的数据，为了保证前半部分都是小于基准点的数据，后半部分都是大于基准点的数据
            if (j > i) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }

        // 遍历结束后，i位置是最后一个小于基准点的数据位置，将基准点放入
        nums[begin] = nums[i];
        nums[i] = tmp;

        // 根据基准点前后部分再分别排序
        sort(nums, begin, i - 1);
        sort(nums, i + 1, end);
    }
}
