package com.gqq.leetcode.tag.search;

/**
 * 查找算法:
 *
 * 1. 二分查找
 *      时间复杂度：O(logn)
 *      二分查找应用场景的局限性：
 *      1. 依赖于顺序表的数据结构，比如数组，因为二分查找需要根据索引随机访问，链表的随机问时间复杂度是O(n),不可以
 *      2. 二分查找依赖于有序数组
 *      3. 数据量太小不适合，数据量太小用顺序查找即可，例外：数据存储的数据之间对比很耗时，需要尽可能减少对比次数的
 *      4. 数据量太大也不适合：这个的原因在于内存空间，数组需要申请连续的内存空间，数据量过大可能
 *
 *      变形问题：
 *      1. 查找第一个值等于给定值的元素
 *      2. 查找最后一个值等于给定值的元素
 *      3. 查找第一个大于等于给定值的元素
 *      4. 查找最后一个小于等于给定值的元素
 *
 *      二分法能解决的问题大部分更倾向于散列表或二叉树。
 *      但是二分查找更适合近似查找问题。
 *      注意：终止条件、区间上下界更新方法、返回值选择
 *
 *
 *
 *
 */
public class Search {
    public static void main(String[] args) {
//        bSearch1(new int[]{8, 11, 19, 23, 27, 33, 45, 55, 67, 98}, 10, 33);
//        bSearch2(new int[]{8, 11, 19, 23, 27, 33, 45, 55, 67, 98}, 0, 9, 33);
//        bSearch3(new int[]{8, 11, 19, 19, 19, 19, 45, 55, 67, 98}, 19);
//        bSearch4(new int[]{8, 11, 19, 23, 27, 33, 45, 55, 67, 98}, 20);
//        bSearch5(new int[]{8, 11, 19, 23, 27, 33, 45, 55, 67, 98}, 20);
        bSearch6(new int[]{8, 11, 19, 23, 27, 33, 45, 55, 67, 98}, 20);
    }

    // 非递归的简单二分查找: 最简单的实现，注意几个问题：
    // 1. 退出的条件：low <= high，等于的条件
    // 2. mid的取值：目前这样写会存在问题，比如溢出，可以优化为low+(high-low)/2，更优一步，用位运算：low+((high-low)>>1)，除法上位运算更快一些
    // 3. low和high的更新：判断之后更新low和high时注意+1/-1, 否则low==mid/high==mid可能造成死循环
    public static int bSearch1(int[] a, int n, int val) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == val) {
                return mid;
            } else if (a[mid] < val) {
                low = mid + 1;
            } else if (a[mid] > val) {
                high = mid - 1;
            }
        }
        return -1;
    }

    // 递归简单的二分查找 并优化
    public static int bSearch2(int[] a, int low, int high, int val) {

        if (low > high) return -1;

        int mid = low + ((high - low) >> 1);

        if (a[mid] == val) {
            return mid;
        } else if (a[mid] < val) {
            return bSearch2(a, mid + 1, high, val);
        } else {
            return bSearch2(a, low, mid - 1, val);
        }
    }

    /**
     * 上面两个是最简单的实现，没有考虑很多种情况，比如重复性的数据
     * 常见的二分查找变形问题：
     * 1. 查找第一个值等于给定值的元素
     * 2. 查找最后一个值等于给定值的元素
     * 3. 查找第一个大于等于给定值的元素
     * 4. 查找最后一个小于等于给定值的元素
     */

    // 查找第一个值等于给定值的元素
    public static int bSearch3(int[] a, int val) {
        int low = 0;
        int high = a.length - 1;
        int index = -1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] == val) {
                high = mid - 1;
                index = mid;
            } else if (a[mid] < val) {
                low = mid + 1;
            } else if (a[mid] > val) {
                high = mid - 1;
            }
        }
        return index;
    }

    // 查找最后一个值等于给定值的元素
    public static int bSearch4(int[] a, int val) {
        int low = 0;
        int high = a.length - 1;
        int index = -1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] == val) {
                // 与得到第一个值时的区别
                low = mid + 1;
                index = mid;
            } else if (a[mid] < val) {
                low = mid + 1;
            } else if (a[mid] > val) {
                high = mid - 1;
            }
        }
        return index;
    }

    // 查找第一个大于等于给定值的元素
    public static int bSearch5(int[] a, int val) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= val) {
                if (mid == 0 || a[mid - 1] < val) {
                    return a[mid];
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    // 查找最后一个小于等于给定值的元素
    public static int bSearch6(int[] a, int val) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] <= val) {
                if (mid == a.length - 1 || a[mid + 1] > val) {
                    return a[mid];
                } else {
                    low = mid + 1;
                }
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // 示例代码：
    public int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                // 第一个等于给定值
                if ((mid == 0) || (a[mid - 1] != value)) return mid;
                else high = mid - 1;

                // 最后一个等于给定值
                if ((mid == n - 1) || (a[mid + 1] != value)) return mid;
                else high = mid - 1;
            }
        }
        return -1;
    }
}
