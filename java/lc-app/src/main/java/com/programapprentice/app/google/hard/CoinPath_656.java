package com.programapprentice.app.google.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinPath_656 {
    /**
     https://leetcode.com/problems/coin-path/description/
     Given an array A (index starts at 1) consisting of N integers: A1, A2, ...,
     AN and an integer B. The integer B denotes that from any place (suppose the
     index is i) in the array A, you can jump to any one of the place in the array
     A indexed i+1, i+2, …, i+B if this place can be jumped to. Also, if you step on
     the index i, you have to pay Ai coins. If Ai is -1, it means you can’t jump to
     the place indexed i in the array.

     Now, you start from the place indexed 1 in the array A, and your aim is to
     reach the place indexed N using the minimum coins. You need to return the path
     of indexes (starting from 1 to N) in the array you should take to get to the place
     indexed N using minimum coins.

     If there are multiple paths with the same cost, return the lexicographically smallest such path.

     If it's not possible to reach the place indexed N then you need to return an empty array.

     Example 1:
     Input: [1,2,4,-1,2], 2
     Output: [1,3,5]
     Example 2:
     Input: [1,2,4,-1,2], 1
     Output: []
     Note:
     Path Pa1, Pa2, ..., Pan is lexicographically smaller than Pb1, Pb2, ..., Pbm,
     if and only if at the first i where Pai and Pbi differ, Pai < Pbi; when no such i exists, then n < m.
     A1 >= 0. A2, ..., AN (if exist) will in the range of [-1, 100].
     Length of A is in the range of [1, 1000].
     B is in the range of [1, 100].

     Solution:
     http://blog.csdn.net/magicbean2/article/details/79175717
     * */
    // This cannot fill the low lexicographically requirement
    public List<Integer> cheapestJumpWrong(int[] A, int B) {
        if (A == null || A.length == 0) {
            return new ArrayList<Integer>();
        }
        int n = A.length;
        List<Integer> result = new ArrayList<Integer>();
        int[] opts = new int[n];
        int[] pres = new int[n];
        pres[0] = -1;
        opts[0] = A[0];
        for(int i = 1; i < n; i++) {
            opts[i] = -1;
            pres[i] = -1;
            if (A[i] == -1) {
                continue;
            }
            int min = Integer.MAX_VALUE;
            for(int j = i-1; j >= Math.max(0, i-B); j--) {
                if(opts[j] == -1) {
                    continue;
                } else {
                    if (min > opts[j] + A[i]) {
                        min = opts[j] + A[i];
                        opts[i] = min;
                        pres[i] = j;
                    }
                }
            }
//            for(int j = Math.max(0, i-B); j < i; j++) {
//                if(opts[j] == -1) {
//                    continue;
//                } else {
//                    if (min > opts[j] + A[i]) {
//                        min = opts[j] + A[i];
//                        opts[i] = min;
//                        pres[i] = j;
//                    }
//                }
//            }
        }
        if (opts[n-1] == -1) {
            return result;
        }
        int pre = n-1;
        while(pre != -1) {
            result.add(0, pre+1);
            pre = pres[pre];
        }
        return result;
    }

    // Solution:
    public List<Integer> cheapestJump(int[] A, int B) {
        int[] next = new int[A.length];
        long[] dp = new long[A.length];
        Arrays.fill(next, -1);
        List<Integer> result = new ArrayList<Integer>();
        for (int i = A.length - 2; i >= 0; i--) {
            long minCost = Integer.MAX_VALUE;
            for (int j = i + 1; j <= i + B && j < A.length; j++) {
                if (A[j] >= 0) {
                    long cost = A[i] + dp[j];
                    if (cost < minCost) {
                        minCost = cost;
                        next[i] = j;
                    }
                }
            }
            dp[i] = minCost;
        }

        int i = 0;
        for (; i < A.length && next[i] > 0; i = next[i]) {
            result.add(i + 1);
        }
        result.add(A.length);
        return i == A.length - 1 && A[i] >= 0 ? result : new ArrayList<Integer>();
    }
}
