package com.java.leetcode.easy;

/**
 * @author haoqi.thq
 * @version $Id: MergeTwoSortedList, v 0.1 2016/9/24 18:04 haoqi.thq Exp $
 */
public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode node = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = l1;
                node = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                node = l2;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            node.next = l2;
        } else {
            node.next = l1;
        }
        return newHead.next;
    }
}
