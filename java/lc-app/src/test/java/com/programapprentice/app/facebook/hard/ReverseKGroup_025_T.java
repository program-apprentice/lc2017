package com.programapprentice.app.facebook.hard;

import com.programapprentice.app.model.ListNode;
import com.programapprentice.app.util.TestUtil;
import org.junit.Test;

public class ReverseKGroup_025_T {
    ReverseNodesInKGroup_025 solution = new ReverseNodesInKGroup_025();

    @Test
    public void test1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode newHead = solution.reverseKGroup(head, 3);
        TestUtil.printListNode(newHead);
    }

    @Test
    public void test2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode newHead = solution.reverseKGroup(head, 2);
        TestUtil.printListNode(newHead);
    }

    @Test
    public void test3() {
        ListNode head = new ListNode(1);
        ListNode newHead = solution.reverseKGroup(head, 2);
        TestUtil.printListNode(newHead);
    }
}
