package com.gqq.leetcode.tag.heap;

/**
 * 堆：
 * - 是一个完全二叉树
 * - 堆中每一个节点的值都必须大于等于（或小于等于）其子树中每个节点的值。
 *
 * 堆排序：
 * 1. 建堆 时间复杂度O(n)
 * 2. 排序 时间复杂度O(nlogn)
 *
 * 堆应用：
 * 1. 优先级队列
 * 2. Top K
 * 3.
 */
public class Heap {

    private int[] a; // 数组，存储的坐标从1开始
    private int n; // 堆可以存储的最大数量
    private int count; // 当前已经存储的数据量
    private int L;

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    // 插入
    public void insert(int data) {
        if (count >= n) return;
        ++count;
        a[count] = data;
        int i = count;
        while (i / 2 > 0 && a[i] > a[i / 2]) { // 自下向上堆化
            swap(a, i, i / 2);
            i = i / 2;
        }
    }

    // 删除堆顶元素
    public void removeMax() {
        if (count == 0) return;
        a[1] = a[count];
        --count;
        int i = 1;
        // 堆化
        heapify(a, i);
    }

    // 堆排序

    // 建堆
    public void buildHeap(int[] a, int n) {
        L = n - 1;
        for (int i = n / 2; i >= 1; --i) {
            heapify(a, i);
        }
    }

    // 排序
    public void sort(int[] a, int n) {
        // 先堆化
        buildHeap(a, n);
        // 排序：堆顶是最大的值，将堆顶与最后一个数交换，然后再将其他的数据进行堆化，一直循环，直到堆中数据剩1
        int k = n;
        while (k > 1) {
            swap(a, 1, k);
            --k;
            heapify(a, 1);
        }
    }

    // 堆化：自上而下堆化
    private void heapify(int[] nums, int i) {
        int l = 2 * i;
        int r = l + 1;
        int largest = i;
        if ((l <= L) && (nums[l] > nums[largest]))
            largest = l;
        if ((r <= L) && (nums[r] > nums[largest]))
            largest = r;
        if (largest != i) {
            swap(nums, i, largest);
            heapify(nums, largest);
        }
    }


    // -----------------------------网络参考堆化和排序示例-----------------------------
    private void heapSort(int[] nums) {
        buildHeap(nums);
        int L = nums.length - 1;
        for (int i = L; i >= 1; i--) {
            swap(nums, 0, i);
            L = L - 1;
            heapify(nums, L, 0);
        }
    }

    private void buildHeap(int[] nums) {
        int L = nums.length - 1;
        for (int i = L / 2; i >= 0; i--)
            heapify(nums, L, i);
    }

    //max-heap
    private void heapify(int[] nums, int L, int i) {
        int l = 2 * i;
        int r = l + 1;
        int largest = i;
        if ((l <= L) && (nums[l] > nums[largest]))
            largest = l;
        if ((r <= L) && (nums[r] > nums[largest]))
            largest = r;
        if (largest != i) {
            swap(nums, i, largest);
            heapify(nums, L, largest);
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
