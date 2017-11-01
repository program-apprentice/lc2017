package com.programapprentice.app.facebook.easy;

import com.programapprentice.app.model.TreeNode;

public class SymmetricTree101 {
    /**
     [101] Symmetric Tree

     https://leetcode.com/problems/symmetric-tree

     Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

     For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

         1
        / \
       2   2
      / \ / \
     3  4 4  3

     But the following [1,2,2,null,3,null,3]  is not:

        1
       / \
      2   2
       \   \
       3    3

     Note:
     Bonus points if you could solve it both recursively and iteratively.
     */

    public boolean isSameOrSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if(leftNode == null && rightNode == null) {
            return true;
        }
        if(leftNode == null || rightNode == null) {
            return false;
        }

        if(leftNode.val != rightNode.val) {
            return false;
        }
        return isSameOrSymmetric(leftNode.left, rightNode.right)
                && isSameOrSymmetric(leftNode.right, rightNode.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isSameOrSymmetric(root.left, root.right);
    }
}
