package com.gqq.leetcode.difficulty.medium;

import com.gqq.leetcode.SingleLinkedNode;

/**
 * Created by gqq on 2020/3/19.
 */

/**

Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.

 解法说明：
 主要是借助一个空链表头，其次是链表的反转
 1、

 */
public class LC024 {

    public static void main(String[] args) {

    }

    public SingleLinkedNode swapPairs(SingleLinkedNode head) {

        // 定义一个空链表头
        SingleLinkedNode singleLinkedNode = new SingleLinkedNode(0);

        // 作为传入的链表头
        singleLinkedNode.next = head;

        // 创建一个用于操作反转的链表
        SingleLinkedNode point = singleLinkedNode;
        while (point.next != null && point.next.next != null) {

            // 交换链表的节点：链表反转
            SingleLinkedNode s1 = point.next;
            SingleLinkedNode s2 = s1.next;
            s1.next = s2.next;
            s2.next = s1;
            point.next = s2;

            // 开始下一轮交换
            point = s1;
        }

        return singleLinkedNode.next;
    }

}
