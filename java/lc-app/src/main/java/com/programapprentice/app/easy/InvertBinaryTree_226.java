package com.programapprentice.app.easy;

import com.programapprentice.app.model.TreeNode;

public class InvertBinaryTree_226 {
    /**
     [226] Invert Binary Tree

     https://leetcode.com/problems/invert-binary-tree

     Invert a binary tree.
              4
            /   \
           2     7
          / \   / \
         1   3 6   9

         to
              4
            /   \
           7     2
          / \   / \
         9   6 3   1

     Trivia:
     This problem was inspired by this original tweet by Max Howell:
     Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so fuck off.
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        TreeNode tmp = root.left;
        root = root.right;
        root.right = tmp;
        return root;
    }

}
