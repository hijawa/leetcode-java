package com.java.leetcode.easy;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 *
 * @author googny
 * @since 2015/6/17
 */
public class RemoveDuplicatesfromSortedList {
    public static void main(String[] args) {
        int[] nums = {1, 4, 4, 5, 6, 6, 7, 7, 7, 8};
        ListNode head = new ListNode(nums[0]);
        ListNode cursor = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            cursor.next = node;
            cursor = node;
        }
        ListNode newNode = new RemoveDuplicatesfromSortedList().deleteDuplicates(head);

        while (newNode != null) {
            System.out.print(newNode.val + " ");
            newNode = newNode.next;
        }
        System.out.println();
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode left, right;
        if (head == null) {
            return head;
        }
        left = head;
        right = head.next;
        while (right != null) {
            if (left.val == right.val) {
                left.next = right.next;
            } else {
                left = right;
            }
            right = right.next;
        }
        return head;

    }
}
