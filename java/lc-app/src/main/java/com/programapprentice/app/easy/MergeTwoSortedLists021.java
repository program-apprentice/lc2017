package com.programapprentice.app.easy;

import com.programapprentice.app.model.ListNode;

public class MergeTwoSortedLists021 {
    /**

     [21] Merge Two Sorted Lists

     https://leetcode.com/problems/merge-two-sorted-lists

     * algorithms
     * Easy (39.23%)
     * Source Code:       21.merge-two-sorted-lists.java
     * Total Accepted:    263.8K
     * Total Submissions: 672.2K
     * Testcase Example:  '[]\n[]'

     Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

     Template:
     */

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode newList = null;
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode np = null;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                if (newList == null) {
                    newList = p1;
                    np = newList;
                } else {
                    np.next = p1;
                    np = np.next;
                }
                p1 = p1.next;
            } else {
                if (newList == null) {
                    newList = p2;
                    np = newList;
                } else {
                    np.next = p2;
                    np = np.next;
                }
                p2 = p2.next;
            }
        }
        if (p1 != null) {
            np.next = p1;
        } else {
            np.next = p2;
        }

        return newList;
    }


}
