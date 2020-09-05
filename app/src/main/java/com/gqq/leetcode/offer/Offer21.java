package com.gqq.leetcode.offer;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 */
public class Offer21 {
    public int[] exchange(int[] nums) {
        if (nums.length == 0) return new int[]{};
        int start = 0, end = nums.length - 1;
        while (start < end) {
            if (nums[start] % 2 == 0 && nums[end] % 2 != 0) {
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
                start++;
                end--;
            } else {
                if (nums[start] % 2 != 0) {
                    start++;
                }
                if (nums[end] % 2 == 0) {
                    end--;
                }
            }
        }
        return nums;
    }
}
