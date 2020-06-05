package com.gqq.leetcode.interview;

import com.gqq.leetcode.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
class LC024 {

    public ListNode swapPairs(ListNode head) {
        ListNode point = new ListNode(0);
        point.next = head;

        ListNode headPoint = point;
        while (headPoint.next != null && headPoint.next.next != null) {
            ListNode node1 = headPoint.next;
            ListNode node2 = node1.next;
            node1.next = node2.next;
            node2.next = node1;
            headPoint.next = node2;

            headPoint = node1;
        }
        return point.next;
    }
}
