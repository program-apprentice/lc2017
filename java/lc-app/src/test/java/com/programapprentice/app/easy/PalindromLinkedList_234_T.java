package com.programapprentice.app.easy;

import com.programapprentice.app.model.ListNode;

import org.junit.Assert;
import org.junit.Test;

public class PalindromLinkedList_234_T {
    PalindromeLinkedList_234 solution = new PalindromeLinkedList_234();

    @Test
    public void test1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        Boolean actual = solution.isPalindrome(head);
        Assert.assertFalse(actual);
    }
}
