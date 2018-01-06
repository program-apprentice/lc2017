package com.programapprentice.app.google.medium;

import java.util.LinkedList;
import java.util.Queue;

public class IntegerReplacement_397 {
    /**
     https://leetcode.com/problems/integer-replacement/description/
     Given a positive integer n and you can do operations as follow:

     If n is even, replace n with n/2.
     If n is odd, you can replace n with either n + 1 or n - 1.
     What is the minimum number of replacements needed for n to become 1?

     Example 1:

     Input:
     8

     Output:
     3

     Explanation:
     8 -> 4 -> 2 -> 1
     Example 2:

     Input:
     7

     Output:
     4

     Explanation:
     7 -> 8 -> 4 -> 2 -> 1
     or
     7 -> 6 -> 3 -> 2 -> 1
     * */
    class Node {
        int number;
        int numOfSteps;

        public Node(int number, int numOfSteps) {
            this.number = number;
            this.numOfSteps = numOfSteps;
        }
    }

    public int integerReplacement(int n) {
        Node node = new Node(n, 0);
        Queue<Node> q = new LinkedList<Node>();
        q.add(node);
        while (!q.isEmpty()) {
            Node cur = q.remove();
            if (cur.number == 1) {
                return cur.numOfSteps;
            }
            if (cur.number % 2 == 0) {
                q.add(new Node(cur.number / 2, cur.numOfSteps+1));
            } else {
                if(cur.number < Integer.MAX_VALUE) {
                    q.add(new Node(cur.number + 1, cur.numOfSteps + 1));
                }
                q.add(new Node(cur.number-1, cur.numOfSteps+1));
            }
        }
        return -1;
    }
}
