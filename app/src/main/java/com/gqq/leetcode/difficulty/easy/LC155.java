package com.gqq.leetcode.difficulty.easy;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 *
 * Example:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 *
 * 参考leetcode讨论区最优解法
 * 解法思路：
 * 借助Stack的方法实现，主要的难点是获取最小值，肯定是在Push的时候去得到最小值
 * 从Push入手，怎么才能在Push的时候获取最小值以及假如最小值在最上方，被pop之后，怎么再次获取最小值
 *
 * 解法说明：
 * 每次push的时候找到最小值及第二最小值，最小值入栈时先将上一次的最小值(第二最小值)入栈，
 * 目的是为了保证当最小值pop出去之后，当前栈中的最小值即是再次pop的数据
 *
 * 比如：入栈 -2，0， -3， 1， -4
 *
 * | -4  |
 * | -3  |
 * |  1  |
 * | -3  |
 * | -2  |
 * |  0  |
 * | -2  |
 * | MAX |
 *
 */

public class LC155 {
    public static void main(String[] args) {

        /**
         * Your MinStack object will be instantiated and called as such:
         * MinStack obj = new MinStack();
         * obj.push(x);
         * obj.pop();
         * int param_3 = obj.top();
         * int param_4 = obj.getMin();
         */

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int min1 = minStack.getMin();
        System.out.println(min1);
        minStack.pop();
        minStack.top();
        int min2 = minStack.getMin();
        System.out.println(min2);
    }

    static class MinStack {

        private Stack<Integer> stack;
        private int min = Integer.MAX_VALUE;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
        }

        public void push(int x) {

            // push到新最小值的时候将x和当前的最小值一起入栈
            if (x < min) {
                stack.push(min);
                min = x;
            }
            stack.push(x);
        }

        public void pop() {
            // push的时候入栈了最小值和第二最小值，所以最小值被pop出之后，再次的pop就是最小值了
            if (stack.pop() == min) min = stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }


}
