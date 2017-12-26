package com.programapprentice.app.google.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindKClosestElements_658 {
    /**
     https://leetcode.com/problems/find-k-closest-elements/description/
     Given a sorted array, two integers k and x, find the k closest elements to x in the array.
     The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

     Example 1:
     Input: [1,2,3,4,5], k=4, x=3
     Output: [1,2,3,4]
     Example 2:
     Input: [1,2,3,4,5], k=4, x=-1
     Output: [1,2,3,4]
     Note:
     The value k is positive and will always be smaller than the length of the sorted array.
     Length of the given array is positive and will not exceed 104
     Absolute value of elements in the array and x will not exceed 104
     * */

    public List<Integer> getSubarray(int[] arr, int left, int right) {
        List<Integer> result = new ArrayList<Integer>();
        for(int i = left; i <= right; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr == null || arr.length == 0) {
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<Integer>();
        if (x < arr[0]) {
            for(int i = 0; i < k; i++) {
                result.add(arr[i]);
            }
            return result;
        } else if (x > arr[arr.length-1]) {
            for(int i = 0; i < k; i++) {
                result.add(arr[arr.length-1-i]);
            }
            return result;
        }
        int index = Arrays.binarySearch(arr, x);
        int left = 0;
        int right = 0;
        int count = 0;
        if (index >= 0) { // find the x
            left = index-1;
            right = index+1;
            count = 1;
        } else { // didn't find x
            int insertionpoint = -1 - index;
            left = insertionpoint-1;
            right = insertionpoint;
            count = 0;
        }
        while(count < k && left >= 0 && right < arr.length) {
            int leftDiff = x - arr[left];
            int rightDiff = arr[right] - x;
            if (leftDiff <= rightDiff) {
                left--;
            } else {
                right++;
            }
            count++;
        }
        if (count == k) {
            return getSubarray(arr, left+1, right-1);
        } else {
            if (left < 0) {
                return getSubarray(arr, 0, k-1);
            } else {
                return getSubarray(arr, arr.length-k, arr.length-1);
            }
        }
    }
}



