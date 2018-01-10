package com.programapprentice.app.google.medium;

import com.programapprentice.app.model.ListNode;

import java.util.List;
import java.util.Stack;

public class PlusOneLinkedList_369 {
    /**
     https://leetcode.com/problems/plus-one-linked-list/description/
     Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.

     You may assume the integer do not contain any leading zero, except the number 0 itself.

     The digits are stored such that the most significant digit is at the head of the list.

     Example:
     Input:
     1->2->3

     Output:
     1->2->4

     Solution:
     http://www.cnblogs.com/grandyang/p/5626389.html
     */
    public ListNode plusOne(ListNode head) {
        Stack<ListNode> s = new Stack<ListNode>();
        ListNode cur = head;
        while(cur != null) {
            s.push(cur);
            cur = cur.next;
        }
        int carry = 1;
        while (!s.isEmpty() && carry != 0) {
            ListNode t = s.pop();
            int sum = t.val + carry;
            t.val = sum % 10;
            carry = sum / 10;
        }
        if (carry == 1) {
            ListNode newhead = new ListNode(1);
            newhead.next = head;
            head = newhead;
        }
        return head;
    }

}
