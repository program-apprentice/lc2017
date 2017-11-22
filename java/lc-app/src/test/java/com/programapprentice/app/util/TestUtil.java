package com.programapprentice.app.util;

import com.programapprentice.app.model.ListNode;

public class TestUtil {
    public static void printListNode(ListNode head) {
        ListNode p = head;
        while(p != null) {
            System.out.print(p.val + "   ");
            p = p.next;
        }
    }

}