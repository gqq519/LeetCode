package com.gqq.leetcode.difficulty.easy;

import java.util.PriorityQueue;

/**
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.
 *
 * Example:
 *
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * Note:
 * You may assume that nums' length ≥ k-1 and k ≥ 1.
 *
 * 解题思路：
 * 借助优先级队列，只存储前k个最大的值
 * 优先级队列 PriorityQueue 默认使用最小堆，所以添加到queue中时，对比堆顶的元素即可。
 *
 * 优先级队列 PriorityQueue 实现最大堆可以借助比较器：
 * PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
 *      @Override
 *      public int compare(Integer o1, Integer o2) {
 * 		    // 以下是对比较器升序、降序的理解.
 * 			// (1) 写成return o1.compareTo(o2) 或者 return o1-o2表示升序
 * 			// (2) 写成return o2.compareTo(o1) 或者return o2-o1表示降序
 *          return o2.compareTo(o1);
 * 			}
 * 		}) ;
 */
public class LC703 {

    public static void main(String[] args) {
        int k = 3;
        int[] arr = new int[]{4, 1, 8, 2};
        KthLargest kthLargest = new KthLargest(3, arr);
        kthLargest.add(3);   // returns 4
        kthLargest.add(5);   // returns 5
        kthLargest.add(10);  // returns 5
        kthLargest.add(9);   // returns 8
        kthLargest.add(4);   // returns 8
    }

    static class KthLargest {

        private PriorityQueue<Integer> queue = new PriorityQueue<>();
        private int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int i = 0; i < nums.length; i++) {
                add(nums[i]);
            }
        }

        public int add(int val) {
            if (queue.size() < k) {
                queue.add(val);
            } else if (queue.peek() < val) {
                queue.poll();
                queue.add(val);
            }
            System.out.println(queue.peek());
            return queue.peek();
        }
    }

}
