package com.programapprentice.app.facebook.medium;

public class ProductOfArrayExceptSelf_238 {
    /**
     [238] Product of Array Except Self

     https://leetcode.com/problems/product-of-array-except-self

     Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal
     to the product of all the elements of nums except nums[i].

     Solve it without division and in O(n).

     For example, given [1,2,3,4], return [24,12,8,6].

     Follow up:
     Could you solve it with constant space complexity?
     (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
     * */
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        if (nums.length == 1) {
            return nums;
        }

        int[] products = new int[nums.length];
        products[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            products[i] = products[i-1] * nums[i];
        }
        int product = nums[nums.length - 1];
        products[nums.length - 1] = products[nums.length - 2];
        for(int i = nums.length-2; i >= 1; i--) {
            products[i] = products[i-1] * product;
            product *= nums[i];
        }
        products[0] = product;
        return products;
    }
}
