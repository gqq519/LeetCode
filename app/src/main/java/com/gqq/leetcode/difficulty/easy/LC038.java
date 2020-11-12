package com.gqq.leetcode.difficulty.easy;

/**
 * https://leetcode-cn.com/problems/count-and-say/
 *
 * 报数：报上一个的数
 * 1：1
 * 2：11 一个1
 * 3：21 两个1
 * 4：1211 一个2一个1
 * 5：。。。。。。
 *
 *
 * 解法思路：
 * 1. 首先定义一个num，用于记录当前计算的第几个数据，主要是与需要计算的第n个数对比
 * 2. 定义一个result，来存放最终的结果
 * 3. num和result的初始值：肯定是从1开始依次计算，那么num = 1; result = "1";
 * 4. 计算第n个数，那么肯定是从1开始依次计算直到计算到n，那么借助while循环，直到num >= n ( 其实就是==)
 * 5. 开始依次循环计算每一条的数据：
 *      currentCount：当前报数重复的数值的个数，比如两个1的2，currentCount = 2；
 *      currentNum：  当前的索引的数值，比如两个1的1，currentNum = 1；
 *      StringBuilder：用于记录每次循环后的字符串，用于下一轮的计算，主要借助他的可拓展性
 * 6. while 内的for循环：用于遍历每一个num对应的字符串的遍历，为的是计算下一个数的字符串
 *      遍历Result的数据
 * 7. 返回数据
 *
 */
public class LC038 {

    public static void main(String[] args) {
        String countAndSay = countAndSay(5);
        System.out.println(countAndSay);
    }

    public static String countAndSay(int n) {
        int num = 1;
        String result = "1";

        while (num < n) {
            int currentCount = 0;
            char currentNum = result.charAt(0);
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < result.length(); i++) {

                // 判断有几个相同的数=数据
                if (currentNum == result.charAt(i)) {
                    currentCount ++;
                } else {

                    // 没有相同的数据之后，把当前报的数及数值添加到字符串中
                    stringBuilder.append(currentCount);
                    stringBuilder.append(currentNum);

                    // 再继续往后报数
                    currentCount = 1;
                    currentNum = result.charAt(i + currentCount - 1);
                }

                // 为的是当最后一条数据报数结束要添加到字符串中
                if (i == result.length() - 1) {
                    stringBuilder.append(currentCount);
                    stringBuilder.append(currentNum);
                }
            }

            result = stringBuilder.toString();
            num ++;
        }
        return result;
    }

}
