package com.programapprentice.app.google.medium;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SuperUglyNumber_313 {
    /**
     https://leetcode.com/problems/super-ugly-number/description/
     Write a program to find the nth super ugly number.

     Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.

     Note:
     (1) 1 is a super ugly number for any given primes.
     (2) The given numbers in primes are in ascending order.
     (3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
     (4) The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
     * */
    public int nthSuperUglyNumberLTE(int n, int[] primes) {
        long[] results = new long[n];
        results[0] = 1;
        PriorityQueue<Long> queue = new PriorityQueue<Long>();
        for(int prime : primes) {
            queue.add((long)prime);
        }
        Set<Long> visited = new HashSet<Long>();
        visited.add(1L);
        for(int i = 1; i < n; i++) {
            long cur = queue.poll();
            while(visited.contains(cur)) {
                cur = queue.poll();
            }
            visited.add(cur);
//            System.out.println(cur);
            results[i] = cur;
            for(int prime : primes) {
                if (prime * cur > 0) {
                    queue.add(prime * cur);
                }
            }
        }
        return (int)results[n-1];
    }

    class Node implements Comparable<Node> {
        int i;
        int val;
        final int prime;

        public Node(int i, int val, int prime) {
            this.i = i;
            this.val = val;
            this.prime = prime;
        }

        public int compareTo(Node o) {
            return this.val - o.val;
        }
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ans = new int[n];
        ans[0] = 1;
        PriorityQueue<Node> q = new PriorityQueue<Node>();
        for (int prime : primes) q.add(new Node(0, prime, prime));
        for (int i = 1; i < n; i++) {
            Node cur = q.poll();
            ans[i] = cur.val;
            while (!q.isEmpty() && q.peek().val == cur.val) {
                Node t = q.poll();
                ++t.i;
                t.val = ans[t.i] * t.prime;
                q.add(t);
            }
            cur.i++;
            cur.val = ans[cur.i] * cur.prime;
            q.add(cur);
        }
        return ans[n - 1];
    }
}

