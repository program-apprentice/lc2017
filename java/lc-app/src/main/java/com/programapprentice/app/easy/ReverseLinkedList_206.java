package com.programapprentice.app.easy;

import com.programapprentice.app.model.ListNode;

public class ReverseLinkedList_206 {
    /**
     [206] Reverse Linked List

     https://leetcode.com/problems/reverse-linked-list

     Reverse a singly linked list.

     click to show more hints.

     Hint:
     A linked list can be reversed either iteratively or recursively. Could you implement both?

     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = new ListNode(1);
        ListNode p = head;
        ListNode q = null;
        while(p != null) {
            q = p.next;
            p.next = newHead.next;
            newHead.next = p;
            p = q;
        }

        return newHead.next;
    }
}
