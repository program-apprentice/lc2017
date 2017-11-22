package com.programapprentice.app.facebook.hard;

import com.programapprentice.app.model.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists_023 {
    /**
     https://leetcode.com/problems/merge-k-sorted-lists/description/
     * */

    class ListNodeComparator implements Comparator<ListNode> {
        public int compare(ListNode a, ListNode b) {
            return a.val - b.val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        if (lists == null || lists.length == 0) {
            return dummy.next;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new ListNodeComparator());
        for(ListNode list: lists) {
            if (list != null) {
                queue.add(list);
            }
        }
        while(!queue.isEmpty()) {
            ListNode node = queue.poll();
            tail.next = node;
            tail = node;
            node = node.next;
            if (node != null) {
                queue.add(node);
            }
        }

        return dummy.next;
    }
}
