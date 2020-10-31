package com.gqq.leetcode.offer;

import android.nfc.tech.Ndef;

import com.gqq.leetcode.difficulty.easy.LC021;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 *
 *
 * 7-13-11-10-1-null
 *
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 *
 * 解题说明：
 * 链表的深拷贝，返回一个相同的新链表
 * 1 将当前链表的Node全部拷贝一份新Node
 * 2 排列Node之间的关系
 *
 *
 * 解题方法：
 * 1 哈希表存储的方式：利用map存储每一个当前的node和新node，再通过遍历或者node之间的关系
 * 2 原地复制的方式：1-2-3  复制为  1-1-2-2-3-3，再排列复制Node的random关系，最后拆分新旧Node
 *
 */
public class Offer35 {

    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;
        node1.random = null;

        node2.next = node3;
        node2.random = node1;

        node3.next = node4;
        node3.random = node5;

        node4.next = node5;
        node4.random = node3;

        node5.next = null;
        node5.random = node1;

        copyRandomList2(node1);
    }

    // 1、Hash表的方式
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node curr = head;
        HashMap<Node, Node> map = new HashMap<>();
        // 复制存储新Node
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            // 排列新Node的关系
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }

    // 2、原地复制的方式
    public static Node copyRandomList2(Node head) {
        // 原地复制一份新Node，1-2-3----> 1-1-2-2-3-3
        if (head == null) return null;
        Node temp = head;
        while (temp != null) {
            Node copy = new Node(temp.val);
            copy.next = temp.next;
            temp.next = copy;
            temp = temp.next.next;
        }
        // 根据原Node排列新Node的random关系
        temp = head;
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        // 拆分原Node与新Node
        Node oldList = head;
        Node newList = head.next;
        Node res = head.next;
        while (oldList != null) {
            oldList.next = oldList.next.next;
            newList.next = newList.next == null ? null : newList.next.next;
            oldList = oldList.next;
            newList = newList.next;
        }
        return res;
    }


    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
