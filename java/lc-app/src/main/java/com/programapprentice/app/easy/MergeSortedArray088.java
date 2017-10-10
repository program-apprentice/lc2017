package com.programapprentice.app.easy;

public class MergeSortedArray088 {
    /**
     [88] Merge Sorted Array

     https://leetcode.com/problems/merge-sorted-array

     Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

     Note:
     You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
     * */
    /**
     Question: is this descending or ascending?
     * */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
         if(nums2 == null || nums2.length == 0) {
             return;
         }
         if(nums1 == null || nums1.length == 0) {
             nums1 = nums2;
             return;
         }
         int p1 = m - 1;
         int p2 = n - 1;
         int p = m + n - 1;
         while(p1 >= 0 && p2 >= 0) {
             if (nums1[p1] > nums2[p2]) {
                 nums1[p] = nums1[p1];
                 p1 --;
             } else {
                 nums1[p] = nums2[p2];
                 p2 --;
             }
             p--;
         }
         if (p1 >= 0) {
             while(p1 >= 0) {
                 nums1[p] = nums1[p1];
                 p--;
                 p1--;
             }
         } else {
             while(p2 >= 0) {
                 nums1[p] = nums2[p2];
                 p--;
                 p2--;
             }
         }
    }
}
