package com.gqq.leetcode.difficulty.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * 解法说明：
 *
 * 利用排序和双指针的方式
 *
 * 1、先进行排序，形成一个有序数组
 * 2、如果数组长度为0或者有序数组第一个数据>0，那么返回空列表
 * 3、通过for循环，依次取得第i位的数据(如果i与i-1的数据相同，就没必要进行判断了)，然后往后找到剩下的两个数据
 * 4、找剩下的两个数据可以利用双指针的方式，从i + 1开始到nums.length - 1，分别向前向后遍历，得到和为 0 - nums[i] 的两条数据
 *
 */
public class LC015 {

    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists.toString());
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        //        Arrays.sort(nums);
        //        List<List<Integer>> res = new LinkedList<>();
        //        for (int i = 0; i < nums.length-2; i++) {
        //            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
        //                int lo = i+1, hi = nums.length-1, sum = 0 - nums[i];
        //                while (lo < hi) {
        //                    if (nums[lo] + nums[hi] == sum) {
        //                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
        //                        while (lo < hi && nums[lo] == nums[lo+1]) lo++;
        //                        while (lo < hi && nums[hi] == nums[hi-1]) hi--;
        //                        lo++; hi--;
        //                    } else if (nums[lo] + nums[hi] < sum) lo++;
        //                    else hi--;
        //                }
        //            }
        //        }
        //        return res;
        //
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length <= 0 || nums[0] > 0) return lists;
        for (int i = 0; i < nums.length - 2; i++) {

            // 如果此轮遍历的数据与上轮的数据一致，不进行遍历了，没有必要
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int low = i + 1, high = nums.length - 1, sum = 0 - nums[i];
            while (low < high) {
                if (nums[low] + nums[high] == sum) {
                    lists.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while (low < high && nums[low] == nums[low + 1]) low++;
                    while (low < high && nums[high] == nums[high - 1]) high--;
                    low++;
                    high--;
                } else if (nums[low] + nums[high] < sum) {
                    low++;
                } else {
                    high--;
                }
            }
        }

        return lists;
    }
}
