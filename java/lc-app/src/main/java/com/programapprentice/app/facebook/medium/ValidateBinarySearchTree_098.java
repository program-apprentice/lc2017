package com.programapprentice.app.facebook.medium;

import com.programapprentice.app.model.TreeNode;

public class ValidateBinarySearchTree_098 {
    /**
     [98] Validate Binary Search Tree

     https://leetcode.com/problems/validate-binary-search-tree

     Given a binary tree, determine if it is a valid binary search tree (BST).

     Assume a BST is defined as follows:

     The left subtree of a node contains only nodes with keys less than the node's key.
     The right subtree of a node contains only nodes with keys greater than the node's key.
     Both the left and right subtrees must also be binary search trees.

     Example 1:

       2
      / \
     1   3

     Binary tree [2,1,3], return true.

     Example 2:

       1
      / \
     2   3

     Binary tree [1,2,3], return false.
     * */

    public boolean isBetween(Integer x, Integer max, Integer min) {
        if (max == null && min == null) {
            return true;
        } else if (max != null && min != null) {
            return x < max && x > min;
        } else if (max == null) {
            return x > min;
        } else { // if (min == null) {
            return x < max;
        }
    }

    public boolean isValidBST(TreeNode root, Integer max, Integer min) {
        if (!isBetween(root.val, max, min)) {
            return false;
        }
        boolean left = true;
        if (root.left != null) {
            left = isValidBST(root.left, root.val, min);
        }
        boolean right = true;
        if (root.right != null) {
            right = isValidBST(root.right, max, root.val);
        }
        return left && right;
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        boolean left = true;
        if (root.left != null) {
            left = isValidBST(root.left, root.val, null);
        }
        boolean right = true;
        if (root.right != null) {
            right = isValidBST(root.right, null, root.val);
        }
        return left && right;
    }

}
