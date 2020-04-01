package com.gqq.leetcode.tag.stack;

import java.util.Stack;

/**
 * You're now a baseball game point recorder.
 * <p>
 * Given a list of strings, each string can be one of the 4 following types:
 * <p>
 * Integer (one round's score): Directly represents the number of points you get in this round.
 * "+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
 * "D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
 * "C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.
 * Each round's operation is permanent and could have an impact on the round before and the round after.
 * <p>
 * You need to return the sum of the points you could get in all the rounds.
 * <p>
 * Example 1:
 * Input: ["5","2","C","D","+"]
 * Output: 30
 * Explanation:
 * Round 1: You could get 5 points. The sum is: 5.
 * Round 2: You could get 2 points. The sum is: 7.
 * Operation 1: The round 2's data was invalid. The sum is: 5.
 * Round 3: You could get 10 points (the round 2's data has been removed). The sum is: 15.
 * Round 4: You could get 5 + 10 = 15 points. The sum is: 30.
 * Example 2:
 * Input: ["5","-2","4","C","D","9","+","+"]
 * Output: 27
 * Explanation:
 * Round 1: You could get 5 points. The sum is: 5.
 * Round 2: You could get -2 points. The sum is: 3.
 * Round 3: You could get 4 points. The sum is: 7.
 * Operation 1: The round 3's data is invalid. The sum is: 3.
 * Round 4: You could get -4 points (the round 3's data has been removed). The sum is: -1.
 * Round 5: You could get 9 points. The sum is: 8.
 * Round 6: You could get -4 + 9 = 5 points. The sum is 13.
 * Round 7: You could get 9 + 5 = 14 points. The sum is 27.
 * Note:
 * The size of the input list will be between 1 and 1000.
 * Every integer represented in the list will be between -30000 and 30000.
 * <p>
 * 入栈的时候根据+ C D 处理integer 的数据，然后入栈。
 * <p>
 * 解题思路：
 * 将数组依次入栈，入栈时判断是不是特殊操作 + C D，对应处理后入栈，最后累加栈中的所有数据，得到sum
 *
 *
 */
public class LC682 {

    public static void main(String[] args) {
        int sum = calPoints(new String[]{"5","-2","4","C","D","9","+","+"});
        System.out.print(sum);
    }

    public static int calPoints(String[] ops) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("+")) {
                // 栈顶和栈顶下的元素进行 + 运算
                int top = stack.pop();
                int peek = stack.peek();
                // 栈顶元素弹出了，再加回去
                stack.push(top);
                // 再在栈顶加上 + 之后的数据
                stack.push(top + peek);

            } else if (ops[i].equals("C")) {
                stack.pop();
            } else if (ops[i].equals("D")) {
                int top = stack.peek();
                stack.push(2 * top);
            } else {
                stack.push(Integer.valueOf(ops[i]));
            }
        }

        for (int score : stack) {
            result += score;
        }

        return result;
    }

}
