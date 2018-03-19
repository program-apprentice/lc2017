package com.programapprentice.app.google.hard;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class SlidingWindowMaximum_239 {
    /**
     https://leetcode.com/problems/sliding-window-maximum/description/
     Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the
     very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

     For example,
     Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

     Window position                Max
     ---------------               -----
     [1  3  -1] -3  5  3  6  7       3
     1 [3  -1  -3] 5  3  6  7       3
     1  3 [-1  -3  5] 3  6  7       5
     1  3  -1 [-3  5  3] 6  7       5
     1  3  -1  -3 [5  3  6] 7       6
     1  3  -1  -3  5 [3  6  7]      7
     Therefore, return the max sliding window as [3,3,5,5,6,7].

     Note:
     You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.

     Follow up:
     Could you solve it in linear time?

     Solution:
     https://segmentfault.com/a/1190000003903509
     * */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[0];
        LinkedList<Integer> deque = new LinkedList<Integer>();
        int[] res = new int[nums.length + 1 - k];
        for(int i = 0; i < nums.length; i++){
            // 每当新数进来时，如果发现队列头部的数的下标，是窗口最左边数的下标，则扔掉
            if(!deque.isEmpty() && deque.peek() == i - k) {
                deque.poll();
            }
            // 把队列尾部所有比新数小的都扔掉，保证队列是降序的
            while(!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.removeLast();
            }
            // 加入新数
            deque.addLast(i); //

            // 队列头部就是该窗口内第一大的
            if((i + 1) >= k) {
                int index = deque.peek();
                res[i + 1 - k] = nums[index];
            }
        }
        return res;
    }
}
