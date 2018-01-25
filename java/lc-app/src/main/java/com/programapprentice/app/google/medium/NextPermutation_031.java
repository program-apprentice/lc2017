package com.programapprentice.app.google.medium;

public class NextPermutation_031 {
    /**
     https://leetcode.com/problems/next-permutation/description/
     Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

     If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

     The replacement must be in-place, do not allocate extra memory.

     Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
     1,2,3 → 1,3,2
     3,2,1 → 1,2,3
     1,1,5 → 1,5,1
     * */
    public boolean isAscending(int[] nums) {
        for(int i = 0; i < nums.length-1; i++) {
            if (nums[i] <= nums[i+1]) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isDescending(int[] nums) {
        for(int i = 0; i < nums.length-1; i++) {
            if (nums[i] >= nums[i+1]) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public void swap(int[] nums, int start, int end) {
        int t = nums[start];
        nums[start] = nums[end];
        nums[end] = t;
    }

    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return;
        }
        if (isAscending(nums)) {
            swap(nums,nums.length-2, nums.length-1);
            return;
        }
        if (isDescending(nums)) {
            int low = 0;
            int high = nums.length-1;
            while(low < high) {
                swap(nums, low, high);
                low++;
                high--;
            }
            return;
        }
        int curIdx = 0;

        for(int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i-1]) {
                curIdx = i-1;
                break;
            }
        }
        int swapIdx = -1;
        for(int i = nums.length-1; i > curIdx; i--) {
            if (nums[i] > nums[curIdx]) {
                swapIdx = i;
                break;
            }
        }
        swap(nums, curIdx, swapIdx);
        int low = curIdx+1;
        int high = nums.length-1;
        while(low < high) {
            swap(nums, low, high);
            low++;
            high--;
        }
    }
}
