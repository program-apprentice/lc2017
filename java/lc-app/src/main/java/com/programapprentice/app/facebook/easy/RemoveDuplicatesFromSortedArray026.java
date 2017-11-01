package com.programapprentice.app.facebook.easy;

public class RemoveDuplicatesFromSortedArray026 {
    /**
     [26] Remove Duplicates from Sorted Array

     https://leetcode.com/problems/remove-duplicates-from-sorted-array

     * algorithms
     * Easy (35.41%)
     * Source Code:       26.remove-duplicates-from-sorted-array.java
     * Total Accepted:    268.5K
     * Total Submissions: 758.3K
     * Testcase Example:  '[]'


     Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.


     Do not allocate extra space for another array, you must do this in place with constant memory.



     For example,
     Given input array nums = [1,1,2],


     Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
     * */

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        int j = 1;
        while(j < nums.length) {
            if(nums[j] == nums[i]) {
                j++;
            } else {
                nums[i+1] = nums[j];
                i++;
            }
        }
        return i+1;
    }

}
