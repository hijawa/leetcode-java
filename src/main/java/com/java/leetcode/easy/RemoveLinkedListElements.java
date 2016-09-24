package com.java.leetcode.easy;

/**
 * Remove all elements from a linked list of integers that have value val.
 * <p/>
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 *
 * @author mti1301
 * @since 2015/6/16.
 */
public class RemoveLinkedListElements {

    public static void main(String[] args) {
        int[] nums = {1,2,2,1};
        ListNode head = new ListNode(nums[0]);
        ListNode cursor = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            cursor.next = node;
            cursor = node;
        }
        ListNode newNode = new RemoveLinkedListElements().removeElements(head, 2);
        while (newNode != null) {
            System.out.print(newNode.val + " ");
            newNode = newNode.next;
        }
        System.out.println();
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode left = null, right = null;
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return head;
        }
        left = head;
        right = head.next;
        while (right != null) {
            if (right.val == val) {
                left.next = right.next;
            } else {
                left = right;
            }
            right = right.next;
        }
        return head;
    }
}
