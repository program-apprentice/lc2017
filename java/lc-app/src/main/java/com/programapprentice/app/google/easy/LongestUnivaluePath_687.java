package com.programapprentice.app.google.easy;

import com.programapprentice.app.model.TreeNode;

import static sun.swing.MenuItemLayoutHelper.max;

public class LongestUnivaluePath_687 {
    /**
     Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.

     Note: The length of path between two nodes is represented by the number of edges between them.

     Example 1:

     Input:

         5
        / \
       4   5
      / \   \
     1   1   5
     Output:

     2
     Example 2:

     Input:

         1
        / \
       4   5
      / \   \
     4   4   5
     Output:

     2
     Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.
     * */

    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        this.max = 0;
        longestPath(root);
        return max;
    }

    public int longestPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = longestPath(root.left);
        int right = longestPath(root.right);
        left = (root.left != null && root.val == root.left.val) ? left + 1 : 0;
        right = (root.right != null && root.val == root.right.val) ? right + 1 : 0;
        this.max = Math.max(max, left+right);
        return Math.max(left, right);
    }
}
