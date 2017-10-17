package com.programapprentice.app.easy;

import com.programapprentice.app.model.TreeNode;

public class SumOfLeftleaves_404 {
    /**
     [404] Sum of Left Leaves

     https://leetcode.com/problems/sum-of-left-leaves

     Find the sum of all left leaves in a given binary tree.

     Example:

        3
       / \
      9  20
      /  \
     15   7

     There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
     * */

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = sumOfLeft(root.left, true);
        int right = sumOfLeft(root.right, false);
        return left + right;
    }

    public int sumOfLeft(TreeNode root, Boolean isLeft) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return isLeft ? root.val : 0;
        }
        int left = sumOfLeft(root.left, true);
        int right = sumOfLeft(root.right, false);
        return left + right;
    }

}
