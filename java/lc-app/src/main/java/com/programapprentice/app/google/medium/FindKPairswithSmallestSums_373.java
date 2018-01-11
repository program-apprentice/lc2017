package com.programapprentice.app.google.medium;

import java.util.ArrayList;
import java.util.List;

public class FindKPairswithSmallestSums_373 {
    /**
     https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/
     You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

     Define a pair (u,v) which consists of one element from the first array and one element from the second array.

     Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

     Example 1:
     Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3

     Return: [1,2],[1,4],[1,6]

     The first 3 pairs are returned from the sequence:
     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
     Example 2:
     Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2

     Return: [1,1],[1,1]

     The first 2 pairs are returned from the sequence:
     [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
     Example 3:
     Given nums1 = [1,2], nums2 = [3],  k = 3

     Return: [1,3],[2,3]

     All possible pairs are returned from the sequence:
     [1,3],[2,3]
     * */
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<int[]>();
        if (k == 0 || nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return result;
        }

        int size = Math.min(nums1.length * nums2.length, k);
        int[] idx = new int[nums1.length];
        for(int i = 0; i < size; i++) {
            int t = 0;
            int sum = Integer.MAX_VALUE;
            for(int j = 0; j < nums1.length; j++) {
                if (idx[j] < nums2.length && sum >= nums1[j] + nums2[idx[j]]) {
                    t = j;
                    sum = nums1[j] + nums2[idx[j]];
                }
            }
            int[] item = new int[2];
            item[0] = nums1[t];
            item[1] = nums2[idx[t]];
            result.add(item);
            idx[t] ++;
        }

        return result;
    }

}
