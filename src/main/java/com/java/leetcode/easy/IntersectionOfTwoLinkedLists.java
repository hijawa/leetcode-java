package com.java.leetcode.easy;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * <p>
 * <p>
 * For example, the following two linked lists:
 * <p>
 * A:          a1 → a2
 * ↘
 * c1 → c2 → c3
 * ↗
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 * <p>
 * <p>
 * Notes:
 * <p>
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 *
 * @author googny
 * @since 2015/6/17
 */
public class IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {
        int[] nums = {4, 4, 4, 4, 4, 4, 4, 4, 4};
        ListNode head = new ListNode(nums[0]);
        ListNode cursor = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            cursor.next = node;
            cursor = node;
        }
        ListNode newNode = new IntersectionOfTwoLinkedLists().getIntersectionNode(head, head);

        while (newNode != null) {
            System.out.print(newNode.val + " ");
            newNode = newNode.next;
        }
        System.out.println();
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode p1 = headA, p2 = headB;
        while (p1 != null) {
            lenA++;
            p1 = p1.next;
        }

        while (p2 != null) {
            lenB++;
            p2 = p2.next;
        }

        int sub = lenA - lenB;
        p1 = sub > 0 ? headA : headB;
        p2 = sub > 0 ? headB : headA;

        int dis = Math.abs(sub);
        while (dis-- != 0) {
            p1 = p1.next;
        }
        while (p1 != null && p2 != null) {
            if (p1 == p2) {
                return p1;
            } else {
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return p1;
    }
}
