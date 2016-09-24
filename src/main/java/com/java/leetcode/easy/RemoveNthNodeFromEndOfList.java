package com.java.leetcode.easy;
/**
 * @author haoqi.thq
 * @version $Id: RemoveNthNodeFromEndOfList, v 0.1 2016/9/24 15:03 haoqi.thq Exp $
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode top = head;
        ListNode back = head;
        ListNode preBack = head;
        for (int i = 0; i < n; i++) {
            top = top.next;
        }
        if (top == null) {
            return head.next;
        }
        while (top != null) {
            preBack = back;
            back = back.next;
            top = top.next;
        }
        preBack.next = back.next;
        return head;
    }
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
