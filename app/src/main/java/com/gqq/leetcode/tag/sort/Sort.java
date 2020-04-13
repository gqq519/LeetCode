package com.gqq.leetcode.tag.sort;

/**
 * 排序算法：
 * 1. 冒泡排序
 *      冒泡排序是稳定的原地排序：冒泡判断时相同可以不交换
 *      时间复杂度：O(n^2): 最好O(n),最坏O(n^2)
 *      空间复杂度：O(1)，交换时临时变量
 *
 * 2. 插入排序
 *      插入排序是稳定的原地排序：插入时相同不交换
 *      时间复杂度：O(n^2): 最好O(n),最坏O(n^2)
 *      空间复杂度：O(1)，交换时临时变量
 *
 * 3. 选择排序
 *      选择排序是原地、不稳定排序：选择的数据直接交换，会破坏稳定性
 *      时间复杂度：O(n^2): 最好O(n),最坏O(n^2)
 *      空间复杂度：O(1)，交换时临时变量
 *
 * 4. 归并排序： 分治与递归
 *      归并排序是稳定排序：主要取决于数组合并的时候是否会交换位置，代码实现可以保证不会交换。
 *      时间复杂度：O(nlogn), 不仅递归求解的问题可以写成递推公式，递归代码的时间复杂度也可以写成递推公式。
 *          T(1) = C；   n=1时，只需要常量级的执行时间，所以表示为C。
 *          T(n) = 2*T(n/2) + n； n>1
 *          ==> O(nlogn)
 *      空间复杂度：O(n), 合并的时候申请了n个空间的数组用于存放数据，归并排序并不是原地排序，所以应用不广泛

 *      参考资料：
 *      https://www.cnblogs.com/chengxiao/p/6194356.html


 * 5. 快速排序： 分治与递归
 *      快速排序是原地、不稳定的排序算法
 *      时间复杂度：O(nlogn)，最坏时间复杂度O(n^2)
 *      空间复杂度：O(1)，原地排序
 *
 *      参考资料：https://blog.csdn.net/qq_40941722/article/details/94396010
 *
 *      优化：基准点的选择
 *      1. 三数取中
 *      2. 随机法
 *
 * 线性排序
 * 6. 桶排序：
 *
 *

 * 分治是一种解决问题的处理思想，递归是一种编程技巧。

 * Q：
 * 1. 如何在O(n)的时间复杂度内查找一个无序数组中的第k大元素？（归并/快排）
 */
public class Sort {

    public static void main(String[] args) {
//        bubbleSort(new int[]{2, 6, 1, 5, 3}, 5);
//        insertiosSort(new int[]{6, 5, 3}, 5);
//        selectionSort(new int[]{2, 6, 1, 5, 3}, 5);
//        mergeSort(new int[]{8, 4, 5, 7, 1, 3, 6, 2});
        quickSort(new int[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8}, 0, 9);
    }

    // 冒泡排序
    public static void bubbleSort(int[] a, int n) {
        if (n < 1) return;
        for (int i = 0; i < n; i++) {

            // 设置提前退出冒泡的标志
            boolean flag = false;

            // 循环范围：每次冒泡后最大的数在最后，所以循环最大范围是n - i -1
            for (int j = 0; j < n - i - 1; j++) {

                // 交换两个数据
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;
                }
            }

            // 退出循环
            if (!flag) break;
        }
    }

    // 插入排序
    public static void insertiosSort(int[] a, int n) {
        if (n < 1) return;

        // 遍历a中的n的数据
        for (int i = 1; i < n; i++) {

            int value = a[i];
            int j = i - 1;

            // 将a[i] 与 a[j]的数据进行对比：不处理/数据搬移
            for (; j >= 0; j--) {
                if (a[j] > value) {
                    a[j + 1] = a[j]; // 数据迁移
                } else {
                    break;
                }
            }

            // 不处理(j未变化)/数据迁移后(j为小于value的数，且j+1位置被迁移出)
            a[j + 1] = value; // 插入数据
        }
    }

    // 选择排序
    public static void selectionSort(int[] a, int n) {
        if (n < 1) return;

        for (int i = 0; i < n; i++) {

            int min = a[i];
            int index = -1;

            // 找到最小的值以便于交换位置
            for (int j = i; j < n; j++) {
                if (a[j] < min) {
                    min = a[j];
                    index = j;
                }
            }

            // 已经是顺序的之后
            if (index == -1) {
                break;
            }
            // 交换位置
            int temp = a[i];
            a[i] = min;
            a[index] = temp;
        }
    }

    // Q: 如何在O(n)的时间复杂度内查找一个无序数组中的第k大元素？ A: LC215
    // 归并排序：分治思想
    public static void mergeSort(int[] a) {
        int[] temp = new int[a.length];
        sort(a, 0, a.length - 1, temp);

    }

    public static void sort(int[] a, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            // 分：左右分别归并排序
            sort(a, left, mid, temp);
            sort(a, mid + 1, right, temp);
            // 治：合并排好序的数组
            merge(a, left, mid, right, temp);
        }
    }

    private static void merge(int[] a, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0; // 拷入temp标记的指针

        // i 和 j 依次后移判断数据大小，依次将最小的数放置于temp中
        while (i <= mid && j <= right) {
            if (a[i] < a[j]) {
                temp[t++] = a[i++];
            } else {
                temp[t++] = a[j++];
            }
        }

        // i 和 j 其中一个对应的数组已经遍历结束，将另一个未遍历结束的数组放置于temp中
        // i 数组区间未遍历完全，复制数据
        while (i <= mid) {
            temp[t++] = a[i++];
        }

        // j 数组区间未遍历完全，复制数据
        while (j <= right) {
            temp[t++] = a[j++];
        }

        t = 0;

        // 此时temp是合并后的有序数组，将其给a赋值上
        while (left <= right) {
            a[left++] = temp[t++];
        }
    }


    // 快速排序：分治思想
    public static void quickSort(int[] a, int begin, int end) {

        // 遍历结束
        if (begin > end) {
            return;
        }

        // 将数组的第一个数据作为基准点
        int tmp = a[begin];
        // i 从头向后索引
        int i = begin;
        // j 从尾向前索引
        int j = end;

        // i 和 j 未相遇
        while (i != j) {

            // 从后向前寻找小于基准点的数据
            while (a[j] >= tmp && j > i) {
                j--;
            }

            // 从前向后寻找大于基准点的数据
            while (a[i] <= tmp && j > i) {
                i++;
            }

            // 交换大于/小于基准点的数据，为了保证前半部分都是小于基准点的数据，后半部分都是大于基准点的数据
            if (j > i) {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }

        // 遍历结束后，i位置是最后一个小于基准点的数据位置，将基准点放入
        a[begin] = a[i];
        a[i] = tmp;

        // 根据基准点前后部分再分别排序
        quickSort(a, begin, i - 1);
        quickSort(a, i + 1, end);
    }


}
