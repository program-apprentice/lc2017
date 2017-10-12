package com.programapprentice.app.easy;

import com.programapprentice.app.model.ListNode;

public class LinkedListCycle141 {
    /**
     [141] Linked List Cycle

     https://leetcode.com/problems/linked-list-cycle

     Given a linked list, determine if it has a cycle in it.

     Follow up:
     Can you solve it without using extra space?
    * */

    public boolean hasCycle(ListNode head) {
        ListNode p = head;
        ListNode q = head;
        while(p != null && q != null) {
            p = p.next;
            if (q.next != null && q.next.next != null) {
                q = q.next.next;
            } else {
                return false;
            }
            if (q == p) {
                return true;
            }
        }
        return false;
    }

}
