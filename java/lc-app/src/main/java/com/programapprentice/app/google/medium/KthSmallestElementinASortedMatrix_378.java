package com.programapprentice.app.google.medium;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementinASortedMatrix_378 {
    /**
     https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
     Given a n x n matrix where each of the rows and columns are sorted in ascending order,
     find the kth smallest element in the matrix.

     Note that it is the kth smallest element in the sorted order, not the kth distinct element.

     Example:

     matrix = [
     [ 1,  5,  9],
     [10, 11, 13],
     [12, 13, 15]
     ],
     k = 8,

     return 13.
     Note:
     You may assume k is always valid, 1 ≤ k ≤ n^2.

     Solution:
     http://www.cnblogs.com/grandyang/p/5727892.html
     https://discuss.leetcode.com/topic/53041/java-1ms-nlog-max-min-solution
     * */
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, Collections.<Integer>reverseOrder());
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                queue.add(matrix[i][j]);
                if (queue.size() > k) {
                    queue.remove();
                }
            }
        }
        return queue.poll();
    }

    public class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            int n = matrix.length;
            int l = matrix[0][0], h = matrix[n-1][n-1];
            while (l < h) {
                int m = l + (h - l)/2;
                int count = binarySearch(matrix, m);
                if (count < k) {
                    l = m + 1;
                } else {
                    h = m;
                }
            }
            return l;
        }
        public int binarySearch(int[][] matrix, int target) {
            int n = matrix.length, i = n-1, j = 0;
            int res = 0;
            while (i >= 0 && j <= n-1) {
                if (matrix[i][j] > target) i--;
                else {
                    j++;
                    res += i + 1;
                }
            }
            return res;
        }
    }


}
