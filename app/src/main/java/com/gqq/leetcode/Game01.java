package com.gqq.leetcode;

public class Game01 {

    public static void main(String[] args) {
        boolean pattern1 = containsPattern1(new int[]{1, 2, 4, 4, 4, 4}, 1, 3);
        System.out.println(pattern1);
    }

    public static boolean containsPattern1(int[] arr, int m, int k) {
        int start = 0;
        int repeat = 0;
        while (start + m < arr.length) {
            int cur[] = new int[m];
            for (int i = 0; i < m; i++) {
                cur[i] = arr[start + i];
            }

            for (int i = start + m; i < arr.length; i++) {
                int temp[] = new int[m];
                for (int j = 0; j < m; j++) {
                    temp[j] = arr[i];
                }

                if (String.valueOf(cur).equals(String.valueOf(temp))) {
                    repeat += 1;
                    if (repeat >= k - 1) {
                        return true;
                    } else {
                        start = start + m + 1;
                    }
                } else {
                    continue;
                }
            }
        }
        return false;
    }
}
