package com.programapprentice.app.google.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class WiggleSortII_324 {
    /**
     https://leetcode.com/problems/wiggle-sort-ii/description/
     Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

     Example:
     (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
     (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

     Note:
     You may assume all input has valid answer.

     Follow Up:
     Can you do it in O(n) time and/or in-place with O(1) extra space?
     * */
    public void wiggleSortBug(int[] nums) {
        if (nums == null || nums.length == 0 ) {
            return;
        }
        int median = findKthLargest(nums, (nums.length+1)/2);
        int left = 0;
        int right = nums.length-1;
        int n = nums.length;
        int i = 0;
        while (i <= right) {
            if (nums[newIndex(i, n)] > median) {
                swap(nums, newIndex(left, n), newIndex(i, n));
                left++;
                i++;
            } else if (nums[newIndex(i, n)] < median) {
                swap(nums, newIndex(right, n), newIndex(i, n));
                right--;
            } else {
                i++;
            }
        }

    }

    public void wiggleSort(int[] nums) {
        int[] copy = new int[nums.length];
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) copy[i] = nums[i];
        int index = 1;
        for(int i = nums.length - 1; i > (nums.length - 1) / 2; i--){
            nums[index] = copy[i];
            index += 2;
        }
        index = 0;
        for(int i = (nums.length - 1) / 2; i >= 0; i--){
            nums[index] = copy[i];
            index += 2;
        }
    }

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

    public void swap(int[] nums, int a1, int a2) {
        int t = nums[a1];
        nums[a2] = nums[a1];
        nums[a1] = t;
    }

    /*
    Mapped_idx[Left] denotes the position where the next smaller-than median element  will be inserted.
    Mapped_idx[Right] denotes the position where the next larger-than median element  will be inserted.
    * */
    private int newIndex(int index, int n) {
        return (1 + 2 * index) % (n|1);
    }
}
