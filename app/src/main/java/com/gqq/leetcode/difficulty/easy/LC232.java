package com.gqq.leetcode.difficulty.easy;

import java.util.Stack;

/**
 * Implement the following operations of a queue using stacks.
 *
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * Example:
 *
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // returns 1
 * queue.pop();   // returns 1
 * queue.empty(); // returns false
 * Notes:
 *
 * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 *
 * 解题思路：利用栈实现队列
 * 栈的特点：先入后出，队列的特点：先入先出
 * 借助一个栈存放pop的数据
 *
 */
public class LC232 {

    class MyQueue {

        private Stack<Integer> stack;
        private int front;

        public MyQueue() {
            stack = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            if (stack.isEmpty()) front = x;
            Stack<Integer> tmp = new Stack<>();
            while (!stack.empty()) {
                tmp.push(stack.pop());
            }
            tmp.push(x);
            while (!tmp.empty()) {
                stack.push(tmp.pop());
            }
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            int pop = stack.pop();
            if (!stack.empty()) {
                front = stack.peek();
            }
            return pop;
        }

        /**
         * Get the front element.
         */
        public int peek() {
            return front;
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stack.empty();
        }
    }

}
