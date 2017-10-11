package com.programapprentice.app.easy;

import com.programapprentice.app.model.TreeNode;

public class MaximumDepthOfBinaryTree104 {
    /**
     [104] Maximum Depth of Binary Tree
     https://leetcode.com/problems/maximum-depth-of-binary-tree

     Given a binary tree, find its maximum depth.
     The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     */

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return max(leftDepth, rightDepth) + 1;
    }

    public int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

}
