package com.programapprentice.app.util;

import com.programapprentice.app.model.ListNode;

import java.util.List;

public class TestUtil {
    public static void printListNode(ListNode head) {
        ListNode p = head;
        while(p != null) {
            System.out.print(p.val + "   ");
            p = p.next;
        }
    }

    public static void printArray(int[] nums) {
        for(int n : nums) {
            System.out.print(n + "   ");
        }
    }

    public static void printArrayList(List<Integer> nums) {
        for(int n : nums) {
            System.out.print(n + "   ");
        }
    }

    public static void printStringArrayList(List<String> nums) {
        for(String n : nums) {
            System.out.print(n + "   ");
        }
    }

    public static void printListOfArray(List<int[]> nums) {
        for(int[] n : nums) {
            System.out.print("[");
            for(int i : n) {
                System.out.print(i + " ");
            }
            System.out.print("]");
        }
    }
}
