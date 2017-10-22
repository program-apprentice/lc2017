package com.programapprentice.app.medium;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray_215 {
    /**
     [215] Kth Largest Element in an Array

     https://leetcode.com/problems/kth-largest-element-in-an-array

     Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

     For example,
     Given [3,2,1,5,6,4] and k = 2, return 5.

     Note:
     You may assume k is always valid, 1 ≤ k ≤ array's length.
     * */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(nums.length, Collections.reverseOrder());
        for(int num : nums) {
            pq.add(num);
        }
        int result = 0;
        for(int i = 0; i < k; i++) {
            result = pq.remove();
        }
        return result;
    }

}
