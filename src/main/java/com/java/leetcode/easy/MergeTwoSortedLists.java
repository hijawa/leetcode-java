package com.java.leetcode.easy;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 * @author mti1301
 * @since 2015/6/16.
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        int[] nums1 = {7, 9, 16};
        int[] nums2 = {2, 4, 6, 8, 10, 19};
        ListNode l1 = new ListNode(nums1[0]);
        ListNode cursor = l1;
        for (int i = 1; i < nums1.length; i++) {
            ListNode node = new ListNode(nums1[i]);
            cursor.next = node;
            cursor = node;
        }
        ListNode l2 = new ListNode(nums2[0]);
        cursor = l2;
        for (int i = 1; i < nums2.length; i++) {
            ListNode node = new ListNode(nums2[i]);
            cursor.next = node;
            cursor = node;
        }

        ListNode newNode = new MergeTwoSortedLists().mergeTwoLists(l1, null);
        while (newNode != null) {
            System.out.print(newNode.val + " ");
            newNode = newNode.next;
        }
        System.out.println();
    }


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
