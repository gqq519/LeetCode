package com.gqq.leetcode.difficulty.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement the following operations of a stack using queues.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Example:
 *
 * MyStack stack = new MyStack();
 *
 * stack.push(1);
 * stack.push(2);
 * stack.top();   // returns 2
 * stack.pop();   // returns 2
 * stack.empty(); // returns false
 * Notes:
 *
 * You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 *
 * 解题思路：队列 先进先出 实现 栈的 先进后出
 * 借助另一个队列实现
 */
public class LC225 {
    class MyStack {

        private Queue<Integer> queue = new LinkedList<>();
        private int front;

        /** Initialize your data structure here. */
        public MyStack() {

        }

        /** Push element x onto stack. */
        public void push(int x) {
            Queue<Integer> queue1 = new LinkedList<>();
            queue1.add(x);
            front = x;
            while (!queue.isEmpty()) {
                queue1.add(queue.remove());
            }
            queue = queue1;

        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            int top = queue.poll();
            if (!queue.isEmpty()) {
                front = queue.peek();
            }
            return top;
        }

        /** Get the top element. */
        public int top() {
            return front;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}
