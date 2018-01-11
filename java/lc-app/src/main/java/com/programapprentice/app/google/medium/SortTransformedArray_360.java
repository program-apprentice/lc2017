package com.programapprentice.app.google.medium;

import java.util.ArrayList;
import java.util.List;

public class SortTransformedArray_360 {
    /**
     https://leetcode.com/problems/sort-transformed-array/description/
     Given a sorted array of integers nums and integer values a, b and c. Apply a quadratic function of the form
     f(x) = ax2 + bx + c to each element x in the array.

     The returned array must be in sorted order.

     Expected time complexity: O(n)

     Example:
     nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,

     Result: [3, 9, 15, 33]

     nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5

     Result: [-23, -5, 1, 7]

     Solution:
     http://blog.csdn.net/qq508618087/article/details/51700774
     */

    private int func(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {

        int n = nums.length;
        int[] result = new int[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        int left = 0;
        int right = n-1;
        while(left <= right) {
            int val1 = func(nums[left], a, b, c);
            int val2 = func(nums[right], a, b, c);
            if (a > 0) {
                if (val1 >= val2) {
                    list.add(val1);
                    left++;
                } else {
                    list.add(val2);
                    right--;
                }
            } else {
                if (val1 >= val2) {
                    list.add(val2);
                    right--;
                } else {
                    list.add(val1);
                    left++;
                }
            }
        }
        if (a > 0) {
            for (int i = 0; i < n; i++) {
                result[i] = list.get(n-1-i);
            }
        } else {
            for (int i = 0; i < n; i++) {
                result[i] = list.get(i);
            }
        }
        return result;
    }
}
