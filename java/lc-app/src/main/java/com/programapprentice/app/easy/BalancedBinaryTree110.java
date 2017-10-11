package com.programapprentice.app.easy;

import com.programapprentice.app.model.TreeNode;

public class BalancedBinaryTree110 {
    /**
     [110] Balanced Binary Tree

     https://leetcode.com/problems/balanced-binary-tree

     Given a binary tree, determine if it is height-balanced.

     For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
     */

    /**
     * idea: from leaf node to calculate root node depth. then compare left and right depth.
     * If it's more than 1, return false.
     * If it's less than 1, continue.
     * */

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean leftBalance = isBalanced(root.left);
        boolean rightBalance = isBalanced(root.right);
        if (leftBalance == false || rightBalance == false) {
            return false;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if(Math.abs(leftDepth - rightDepth) > 1) {
            return false;
        }
        return true;
    }
}
