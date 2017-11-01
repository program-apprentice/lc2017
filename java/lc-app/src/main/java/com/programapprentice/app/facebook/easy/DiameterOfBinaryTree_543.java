package com.programapprentice.app.facebook.easy;

import com.programapprentice.app.model.TreeNode;

public class DiameterOfBinaryTree_543 {
    /**
     [543] Diameter of Binary Tree

     https://leetcode.com/problems/diameter-of-binary-tree

     Given a binary tree, you need to compute the length of the diameter of the tree.
     The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

     Example:
     Given a binary tree

         1
        / \
       2   3
      / \
     4   5

     Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

     Note:
     The length of path between two nodes is represented by the number of edges between them.
    * */

    class Info {
        int leftMaxPath;
        int rightMaxPath;
        int totalPath;

        public Info() {
        }

        public Info(int leftMaxPath, int rightMaxPath, int totalPath) {
            this.leftMaxPath = leftMaxPath;
            this.rightMaxPath = rightMaxPath;
            this.totalPath = totalPath;
        }
    }

    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Info info = diameterOfTree(root);
        return max3(info.leftMaxPath, info.rightMaxPath, info.totalPath) - 1;
    }

    public Info diameterOfTree(TreeNode root) {
        if (root == null) {
            return new Info(0, 0, 0);
        }
        Info left = diameterOfTree(root.left);
        Info right = diameterOfTree(root.right);
        Info info = new Info();
        info.leftMaxPath = Math.max(left.leftMaxPath, left.rightMaxPath) + 1;
        info.rightMaxPath = Math.max(right.leftMaxPath, right.rightMaxPath) + 1;
        info.totalPath = max3(Math.max(left.leftMaxPath, left.rightMaxPath)+Math.max(right.rightMaxPath, right.leftMaxPath)+1, left.totalPath, right.totalPath);
        return info;
    }
}
