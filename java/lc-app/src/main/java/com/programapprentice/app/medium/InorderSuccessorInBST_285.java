package com.programapprentice.app.medium;

import com.programapprentice.app.model.TreeNode;

import java.util.Stack;

public class InorderSuccessorInBST_285 {
    /**
     https://leetcode.com/problems/inorder-successor-in-bst/description/
     Given a binary search tree and a node in it,
     find the in-order successor of that node in the BST.

     Note: If the given node has no in-order successor in the tree, return null.
     * */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> visited = new Stack<Integer>();
        stack.push(root);
        visited.push(0); // need to check
        TreeNode preNode = null;
        while(!stack.isEmpty()) {
            TreeNode curNode = stack.peek();
            Integer visit = visited.pop();
            if (visit == 0) {
                visited.push(1);
                if(curNode.left != null) {
                    stack.push(curNode.left);
                    visited.push(0);
                }
            } else if (visit == 1) {
                curNode = stack.pop();
                if (preNode == p) {
                    return curNode;
                }
                if (curNode.right != null) {
                    stack.push(curNode.right);
                    visited.push(0);
                }
                preNode = curNode;
            }
        }
        return null;
    }
}
