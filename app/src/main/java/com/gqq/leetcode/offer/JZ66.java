package com.gqq.leetcode.offer;

/**
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子？
 */
public class JZ66 {

    public static int movingCount(int threshold, int rows, int cols) {
        if (threshold == 0 || rows == 0 || cols == 0) return 0;
        boolean visited[][] = new boolean[rows][cols];
        return movingCore(threshold, rows, cols, 0, 0, visited);
    }

    private static int movingCore(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
        int count = 0;
        if (check(threshold, rows, cols, row, col, visited)) {
            visited[row][col] = true;
            return 1 + movingCore(threshold, rows, cols, row + 1, col, visited)
                    + movingCore(threshold, rows, cols, row, col + 1, visited);
        }
        return count;
    }

    private static boolean check(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
        if (row < rows && col < cols
                && (getSum(row) + getSum(col) <= threshold)
                && !visited[row][col]) {
            return true;
        }
        return false;
    }

    private static int getSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
