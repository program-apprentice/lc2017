package com.programapprentice.app.facebook.medium;

public class SortColors_075 {
    /**
     [75] Sort Colors

     https://leetcode.com/problems/sort-colors

     Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

     Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

     Note:
     You are not suppose to use the library's sort function for this problem.

     Follow up:
     A rather straight forward solution is a two-pass algorithm using counting sort.
     First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
     Could you come up with an one-pass algorithm using only constant space?
     * */

    public void sortColors(int[] nums) {
        if (nums == null | nums.length <= 1) {
            return;
        }
        int zero = 0;
        int two = nums.length - 1;
        int idx = 0;
        int tmp = 0;
        while (idx <= two && zero < nums.length && two >= 0) {
            if (nums[idx] == 0) {
                if (idx == zero) {
                    idx++;
                    continue;
                }
                tmp = nums[zero];
                nums[zero] = 0;
                nums[idx] = tmp;
                zero++;
            } else if (nums[idx] == 2) {
                if (idx == two) {
                    idx++;
                    continue;
                }
                tmp = nums[two];
                nums[two] = 2;
                nums[idx] = tmp;
                two--;
            } else {
                idx++;
            }
        }
    }
}
