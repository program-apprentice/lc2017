package com.programapprentice.app.easy;

import com.programapprentice.app.model.TreeNode;

import java.util.Arrays;
import java.util.Collections;

public class ConvertSortedArrayToBinarySearchTree108 {
    /**
     [108] Convert Sorted Array to Binary Search Tree
     https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree

     Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int l = nums.length;
        TreeNode root = new TreeNode(nums[l / 2]);
        TreeNode left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, l/2));
        TreeNode right = sortedArrayToBST(Arrays.copyOfRange(nums, l/2+1, l));

        root.left = left;
        root.right = right;
        return root;
    }
}
