package com.programapprentice.app.easy;

public class TwoSumII_167 {
    /**
     [167] Two Sum II - Input array is sorted
     https://leetcode.com/problems/two-sum-ii-input-array-is-sorted

     Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

     The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

     You may assume that each input would have exactly one solution and you may not use the same element twice.


     Input: numbers={2, 7, 11, 15}, target=9
     Output: index1=1, index2=2
     * */
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if(numbers == null || numbers.length < 2) {
            return result;
        }
        int endIdx = numbers.length-1;
        int begIdx = 0;
        while(begIdx < endIdx) {
            int sum = numbers[begIdx] + numbers[endIdx];
            if (sum > target) {
                endIdx --;
            } else if (sum < target ) {
                begIdx++;
            } else {
                result[0] = begIdx + 1;
                result[1] = endIdx + 1;
                return result;
            }
        }
        return result;
    }

}
