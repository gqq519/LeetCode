package com.gqq.leetcode.offer;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 *
 * 限制：
 *
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 * 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 *
 *           t
 *      ----------
 *     ｜[1   2   3]｜
 *   l ｜[4   5   6]｜ r
 *     ｜[7   8   9]｜
 *      ----------
 *          b
 *
 *  [[1,2,3], [4,5,6], [7,8,9]]
 *
 *  l: 1, 4, 7  每组数据的第一位索引
 *  r: 3, 6, 9  每组数据的末尾索引
 *  t: 1, 2, 4等 第一组数据的索引
 *  b: 7, 8, 9等 末组数据的索引
 *
 */
public class Offer29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[]{};
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int res[] = new int[(r + 1) * (b + 1)];
        while (true) {
            for (int i = l; i <= r; i++) { // 从左到右遍历
                res[x++] = matrix[t][i]; // 从左到右遍历的数据赋值到res中
            }
            t++; // 从左到右遍历完之后，上层索引+1，并判断是不是全部遍历完了
            if (t > b) break;

            for (int i = t; i <= b; i++) { // 从上到下遍历
                res[x++] = matrix[i][r]; // 从上到下遍历的数据存储到res中
            }
            r--; // 从上到下遍历完之后，右侧索引-1，并判断是不是遍历完了
            if (r < l) break;

            for (int i = r; i >= l; i--) { // 从右向左遍历
                res[x++] = matrix[b][i]; // 存储遍历数据
            }
            b--; // 从右向左遍历完，b的一组数据遍历结束，索引减1
            if (b < t) break;

            for (int i = b; i >= t; i--) { // 从下向上遍历
                res[x++] = matrix[i][l]; // 存储遍历数据
            }
            l++; // 从下向上遍历结束，l的一组数据遍历结束，索引加1
            if (l > r) break;
        }
        return res;
    }
}
