package com.programapprentice.app.easy;

import com.programapprentice.app.model.ListNode;

public class DeleteNodeInALinkedList_237 {
    /**
     [237] Delete Node in a Linked List

     https://leetcode.com/problems/delete-node-in-a-linked-list

     Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

     Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.
     */

    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        ListNode p = node;
        ListNode q = node.next;
        while(q.next != null) {
            p.val = q.val;
            p = p.next;
            q = q.next;
        }
        p.val = q.val;
        p.next = null;
    }
}
