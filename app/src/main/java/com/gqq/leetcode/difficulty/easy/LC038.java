package com.gqq.leetcode.difficulty.easy;

/**
 * Created by gqq on 2019-12-28.
 * 报数：报上一个的数
 * 1：1
 * 2：11 一个1
 * 3：21 两个1
 * 4：1211 一个2一个1
 * 5：。。。。。。
 */
public class LC038 {

    public static void main(String[] args) {
        String countAndSay = countAndSay(5);
        System.out.println(countAndSay);
    }

//    if (j != result.length() - 1 && String.valueOf(result.charAt(j)).equals(current)) {
//        count ++;
//    } else {
//        stringBuilder.append(count);
//        stringBuilder.append(current);
//
//        if (j != result.length() - 1) {
//            count = 1;
//            current = String.valueOf(result.charAt(j));
//        }
//    }

    public static String countAndSay(int num) {
        String result = "1";

        for (int i = 1; i < num; i++) {
            int count = 0;
            String current = String.valueOf(result.charAt(0));
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < result.length(); j++) {
                if (String.valueOf(result.charAt(j)).equals(current)) {
                    count++;
                    if (j == result.length() - 1) {
                        stringBuilder.append(count);
                        stringBuilder.append(current);
                    }
                } else {
                    stringBuilder.append(count);
                    stringBuilder.append(current);

                    count = 1;
                    current = String.valueOf(result.charAt(j));

                    if (j == result.length() -1) {
                        stringBuilder.append(count);
                        stringBuilder.append(current);
                    }
                }
            }
            result = stringBuilder.toString();
        }

        return result;
    }

    public static String count111(int n) {
        String str = "1";
        if (n==1) return str;
        for (int i = 1; i < n; i++) {
            str= c(str,1);
        }

        return str;
    }


    public static String c(String str, int num){
        String s = "";
        for (int i = 0; i < str.length(); i++) {
            if (i + 1 == str.length()) {
                return s + num + str.charAt(i);
            }
            if (str.charAt(i) == str.charAt(i + 1)) {
                num++;
            } else {
                s = s + num + str.charAt(i);
                num = 1;
            }
        }
        return s;
    }

}
