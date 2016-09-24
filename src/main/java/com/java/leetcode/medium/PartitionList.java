package com.java.leetcode.medium;

/**
 * Given a linked list and a value x,
 * partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p/>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p/>
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 *
 * @author mti1301
 * @since 2015/6/15.
 */
public class PartitionList {

    public static void main(String[] args) {
        int[] nums = {4,4,4,4,4,4,4,4,4};
        ListNode head = new ListNode(nums[0]);
        ListNode cursor = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            cursor.next = node;
            cursor = node;
        }
        ListNode newNode = new PartitionList().partition(head, 3);

        while (newNode != null) {
            System.out.print(newNode.val + " ");
            newNode = newNode.next;
        }
        System.out.println();
    }

    public ListNode partition(ListNode head, int x) {
        ListNode mid = new ListNode(x);
        mid.next = null;

        ListNode less = mid;
        ListNode greater = mid;
        ListNode newHead = head;

        ListNode cursor;
        while (head != null) {
            cursor = head;
            head = head.next;
            if (cursor.val < x) {
                if (less != mid) {
                    less.next = cursor;
                } else {
                    newHead = cursor;
                }
                less = cursor;
                less.next = mid;
            } else {
                cursor.next = greater.next;
                greater.next = cursor;
                greater = cursor;
            }
        }
        less.next = mid.next;
        return newHead;
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
