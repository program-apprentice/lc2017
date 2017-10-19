package com.programapprentice.app.medium;

public class RemoveDuplicatesFromSortedArrayII_080 {
    /**
     [80] Remove Duplicates from Sorted Array II

     https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii

     Follow up for "Remove Duplicates":
     What if duplicates are allowed at most twice?

     For example,
     Given sorted array nums = [1,1,1,2,2,3],

     Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.

     * */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int idx = 0;
        int showTimes = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[idx]) {
                idx++;
                nums[idx] = nums[i];
                showTimes = 1;
            } else {
                if (showTimes != 2) {
                    idx++;
                    nums[idx] = nums[i];
                    showTimes++;
                }
            }
        }
        return idx+1;
    }

}
