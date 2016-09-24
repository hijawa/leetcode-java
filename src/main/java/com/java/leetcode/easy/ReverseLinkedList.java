package com.java.leetcode.easy;

/**
 * Reverse a singly linked list.
 * <p/>
 * Hint:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 * @author mti1301
 * @since 2015/6/16.
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = null;
        ListNode cursor = head;
        for (int i = 1; i < 10; i++) {
            ListNode node = new ListNode(i);
            cursor.next = node;
            cursor = node;
        }
//        ListNode newNode = new ReverseLinkedList().reverseList(head);
        ListNode newNode = new ReverseLinkedList().reverselist_recursively(head);
//        ListNode newNode = new ReverseLinkedList().reverseList_iteratively(head);

        while (newNode != null) {
            System.out.print(newNode.val + " ");
            newNode = newNode.next;
        }
        System.out.println();
    }

    public ListNode reverseList(ListNode head) {
        ListNode left, mid, right;
        left = head;
        mid = head;
        right = head;

        if (head == null) {
            return head;
        }
        while (right != null) {
            right = right.next;
            mid.next = left;
            left = mid;
            mid = right;
        }
        head.next = null;
        return left;
    }

    public ListNode reverseList_iteratively(ListNode head) {
        ListNode left = null, right = null;
        while (head != null) {
            right = head.next;
            head.next = left;
            left = head;
            head = right;
        }
        return left;
    }


    public ListNode reverselist_recursively(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverselist_recursively(head.next);
        head.next.next = head;
        head.next = null;
        return node;
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