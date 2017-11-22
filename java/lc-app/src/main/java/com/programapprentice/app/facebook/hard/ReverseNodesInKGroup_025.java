package com.programapprentice.app.facebook.hard;

import com.programapprentice.app.model.ListNode;

public class ReverseNodesInKGroup_025 {
    /**
     https://leetcode.com/problems/reverse-nodes-in-k-group/description/
     * */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 0 || k == 1 || head == null) {
            return head;
        }
        ListNode p = null;
        ListNode q = null;
        ListNode nextStart = head;
        ListNode tmpHead = new ListNode(-1); // tmp head node
        ListNode newTail = tmpHead;
        ListNode r = tmpHead;
        boolean doReverse = true;
        while(nextStart != null) {
            p = nextStart;
            for(int i = 0; i < k; i++) {
                if (nextStart != null ) {
                    nextStart = nextStart.next;
                    doReverse = true;
                } else {
                    doReverse = false;
                    break;
                }
            }
            if (doReverse) {
                newTail = p;
                while(p != nextStart) {
                    q = p.next;
                    p.next = r.next;
                    r.next = p;
                    p = q;
                }
                r = newTail;
            } else {
                while(p != null) {
                    newTail.next = p;
                    newTail = p;
                    p = p.next;
                }
            }
        }
        return tmpHead.next;
    }
}
