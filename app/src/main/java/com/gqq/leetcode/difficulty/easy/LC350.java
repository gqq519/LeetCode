package com.gqq.leetcode.difficulty.easy;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Note:
 *
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 *
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 *
 * 1.
 */
public class LC350 {
    public static void main(String[] args) {
        intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 5});
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        //
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map.getOrDefault(nums2[i], 0) > 0) {
                resultList.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }
        int[] result = new int[resultList.size()];
        int i = 0;
        for (int j = 0; j < resultList.size(); j++) {
            result[i++] = resultList.get(j);
        }
        return result;
    }
}
