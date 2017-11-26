package com.programapprentice.app.google.easy;

import com.programapprentice.app.model.TreeNode;

public class ClosestBinarySearchTreeValue_270 {
    /**
     https://leetcode.com/problems/closest-binary-search-tree-value/description/
     * */
    public int closestValue(TreeNode root, double target) {
        int min = root.val;
        while (root != null) {
            min = Math.abs(target - root.val) < Math.abs(target - min) ? root.val : min;
            root = root.val < target ? root.right : root.left;

        }
        return min;
    }
}
