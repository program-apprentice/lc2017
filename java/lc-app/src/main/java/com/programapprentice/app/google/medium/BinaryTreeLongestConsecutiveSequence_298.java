package com.programapprentice.app.google.medium;

import com.programapprentice.app.model.TreeNode;

public class BinaryTreeLongestConsecutiveSequence_298 {
    /**
     Given a binary tree, find the length of the longest consecutive sequence path.

     The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

     For example,

     1
      \
       3
      / \
     2   4
          \
           5
     Longest consecutive sequence path is 3-4-5, so return 3.
        2
         \
          3
         /
        2
      /
     1
     Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
     * */
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return traverse(root, 1);

    }

    public int traverse(TreeNode root, int pathlength) {
        if (root == null) {
            return pathlength;
        }
        int leftMax = pathlength;

        if (root.left != null) {
            if (root.left.val - root.val == 1) {
                leftMax = traverse(root.left, pathlength + 1);
            } else {
                leftMax = traverse(root.left, 1);
            }
        }

        int rightMax = pathlength;
        if (root.right != null) {
            if (root.right.val - root.val == 1) {
                rightMax = traverse(root.right, pathlength + 1);
            } else {
                rightMax = traverse(root.right, 1);
            }
        }
        return Math.max(pathlength, Math.max(leftMax, rightMax));
    }
}
