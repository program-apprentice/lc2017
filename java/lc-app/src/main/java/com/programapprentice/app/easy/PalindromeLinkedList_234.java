package com.programapprentice.app.easy;

import com.programapprentice.app.model.ListNode;

public class PalindromeLinkedList_234 {
    /**
     [234] Palindrome Linked List

     https://leetcode.com/problems/palindrome-linked-list

     Given a singly linked list, determine if it is a palindrome.

     Follow up:
     Could you do it in O(n) time and O(1) space?
     */

    public int length(ListNode head) {
        ListNode p = head;
        int len = 0;
        while(p != null) {
            len ++;
            p = p.next;
        }
        return len;
    }

    public ListNode reverse(ListNode head) {
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

    public boolean isPalindrome(ListNode head) {
        int len = length(head);
        if (len == 0 || len == 1) {
            return true;
        }
        ListNode halfHead = head;
        for(int i = 0; i < len/2; i++) {
            halfHead = halfHead.next;
        }
        if ((len & 1) == 1) {
            halfHead = halfHead.next;
        }
        halfHead = reverse(halfHead);
        ListNode p = head;
        for(int i = 0; i < len/2; i++) {
            if (p.val != halfHead.val) {
                return false;
            }
            p = p.next;
            halfHead = halfHead.next;
        }
        return true;
    }

}
