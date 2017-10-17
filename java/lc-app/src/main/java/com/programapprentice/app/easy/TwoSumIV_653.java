package com.programapprentice.app.easy;

import com.programapprentice.app.model.TreeNode;

public class TwoSumIV_653 {
    /**
     [653] Two Sum IV - Input is a BST

     https://leetcode.com/problems/two-sum-iv-input-is-a-bst

     Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

     Example 1:

     Input:
         5
        / \
       3   6
      / \   \
     2   4   7

     Target = 9

     Output: True

     Example 2:

     Input:
         5
        / \
       3   6
      / \   \
     2   4   7

     Target = 28

     Output: False
     * */

    public boolean findTarget(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        boolean result = findTarget(root, target, root);
        if (result) {
            return true;
        }
        boolean left = findTarget(root, target, root.left);
        boolean right = findTarget(root, target, root.right);
        return left || right;
    }

    public boolean findTarget(TreeNode tree, int target, TreeNode curNode) {
        if (tree == null || curNode == null) {
            return false;
        }
        int newTarget = target - curNode.val;
        boolean result = find(tree, newTarget, curNode);
        if (result) {
            return true;
        }
        boolean left = findTarget(tree, target, curNode.left);
        boolean right = findTarget(tree, target, curNode.right);
        return left || right;
    }

    public boolean find(TreeNode root, int target, TreeNode usedNode) {
        if (root == null) {
            return false;
        }
        if (target == root.val && root != usedNode) {
            return true;
        }
        if (target < root.val) {
            return find(root.left, target, usedNode);
        } else {
            return find(root.right, target, usedNode);
        }
    }
}
