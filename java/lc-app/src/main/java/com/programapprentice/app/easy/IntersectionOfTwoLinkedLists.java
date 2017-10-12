package com.programapprentice.app.easy;

import com.programapprentice.app.model.ListNode;

public class IntersectionOfTwoLinkedLists {
    /**
     [160] Intersection of Two Linked Lists
     https://leetcode.com/problems/intersection-of-two-linked-lists

     Write a program to find the node at which the intersection of two singly linked lists begins.

     For example, the following two linked lists:

     A:         a1 → a2
                       ↘
                        c1 → c2 → c3
                       ↗
     B:    b1 → b2 → b3

     begin to intersect at node c1.

     Notes:

     If the two linked lists have no intersection at all, return null.
     The linked lists must retain their original structure after the function returns.
     You may assume there are no cycles anywhere in the entire linked structure.
     Your code should preferably run in O(n) time and use only O(1) memory.

     */
    public int getLength(ListNode head) {
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len ++;
            p = p.next;
        }
        return len;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headA == null) {
            return null;
        }
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        ListNode pA = headA;
        ListNode pB = headB;
        if(lenA > lenB) {
            for(int i = 0; i < (lenA-lenB); i++) {
                pA = pA.next;
            }
        } else {
            for(int i = 0; i < (lenB-lenA); i++) {
                pB = pB.next;
            }
        }
        while(pA != null && pB != null) {
            if(pA == pB) {
                return pA;
            }
            pA = pA.next;
            pB = pB.next;
        }
        return null;
    }

}
