package com.programapprentice.app.easy;

public class RotateArray_189 {
    /**
     [189] Rotate Array

     https://leetcode.com/problems/rotate-array

     Rotate an array of n elements to the right by k steps.
     For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

     Note:
     Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.


     [show hint]
     Hint:
     Could you do it in-place with O(1) extra space?


     Related problem: Reverse Words in a String II
     * */

    public void reverse(int[] nums, int startIdx, int endIdx) {
        if(endIdx < 0 || startIdx < 0) {
            return;
        }
        while(startIdx < endIdx) {
            int p = nums[startIdx];
            nums[startIdx] = nums[endIdx];
            nums[endIdx] = p;
            startIdx++;
            endIdx--;
        }
    }
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return;
        }
        k = k % nums.length;
        if(k == 0) {
            return;
        }
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
}
