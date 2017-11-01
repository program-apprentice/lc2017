package com.programapprentice.app.facebook.medium;

public class SearchInRotatedSortedArray_033 {
    /**
     [33] Search in Rotated Sorted Array

     https://leetcode.com/problems/search-in-rotated-sorted-array

     Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

     (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

     You are given a target value to search. If found in the array return its index, otherwise return -1.

     You may assume no duplicate exists in the array.
     * */

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while(low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (target < nums[mid]) {
                if (nums[mid] < nums[high]) {
                    high = mid - 1;
                } else {
                    if (target < nums[low] ) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            } else { // target > nums[mid]
                if (nums[mid] > nums[low]) {
                    low = mid + 1;
                } else {
                    if (target > nums[high]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
            }
        }
        return -1;
    }

}
