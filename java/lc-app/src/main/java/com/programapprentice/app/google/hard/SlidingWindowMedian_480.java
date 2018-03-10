package com.programapprentice.app.google.hard;

import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMedian_480 {
    /**
     https://leetcode.com/problems/sliding-window-median/description/

     Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

     Examples:
     [2,3,4] , the median is 3

     [2,3], the median is (2 + 3) / 2 = 2.5

     Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Your job is to output the median array for each window in the original array.

     For example,
     Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

     Window position                Median
     ---------------               -----
     [1  3  -1] -3  5  3  6  7       1
     1 [3  -1  -3] 5  3  6  7       -1
     1  3 [-1  -3  5] 3  6  7       -1
     1  3  -1 [-3  5  3] 6  7       3
     1  3  -1  -3 [5  3  6] 7       5
     1  3  -1  -3  5 [3  6  7]      6
     Therefore, return the median sliding window as [1,-1,-1,3,5,6].

     Note:
     You may assume k is always valid, ie: k is always smaller than input array's size for non-empty array.

     Solution:
     http://www.cnblogs.com/grandyang/p/6620334.html
     * */

    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> leftHeap = new PriorityQueue<Integer>(Collections.<Integer>reverseOrder());
        PriorityQueue<Integer> rightHeap = new PriorityQueue<Integer>();
        double[] result = new double[nums.length-k+1];
        int resultIdx = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i >= k) {
                // calculate median
                if (leftHeap.contains(nums[i-k])) {
                    leftHeap.remove(nums[i-k]);
                } else if (rightHeap.contains(nums[i-k])) {
                    rightHeap.remove(nums[i-k]);
                }
            }
            if (leftHeap.size() <= rightHeap.size()) {
                if (rightHeap.isEmpty() || nums[i] <= rightHeap.peek()) {
                    leftHeap.add(nums[i]);
                } else {
                    leftHeap.add(rightHeap.peek());
                    int tmp = rightHeap.peek();
                    rightHeap.remove(tmp);
                    rightHeap.add(nums[i]);
                }
            } else {
                if (nums[i] > leftHeap.peek()) {
                    rightHeap.add(nums[i]);
                } else {
                    int tmp = leftHeap.peek();
                    rightHeap.add(tmp);
                    leftHeap.remove(tmp);
                    leftHeap.add(nums[i]);
                }
            }
            if (i >= (k-1)) {
                if (k % 2 == 1) {
                    result[resultIdx] = leftHeap.peek();
                } else {
                    result[resultIdx] = ((double)(leftHeap.peek()) + (double)(rightHeap.peek()))/2.0;
                }
                resultIdx++;
            }
        }
        return result;
    }
}
