package com.programapprentice.app.facebook.medium;

import com.programapprentice.app.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal_102 {
    /**
     [102] Binary Tree Level Order Traversal

     https://leetcode.com/problems/binary-tree-level-order-traversal

     Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

     For example:
     Given binary tree [3,9,20,null,null,15,7],

        3
       / \
      9  20
      /  \
     15   7

     return its level order traversal as:

     [
         [3],
         [9,20],
         [15,7]
     ]
     * */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        List<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            List<TreeNode> nextQueue = new LinkedList<TreeNode>();
            for(TreeNode node : queue) {
                level.add(node.val);
                if (node.left != null) {
                    nextQueue.add(node.left);
                }
                if (node.right != null) {
                    nextQueue.add(node.right);
                }
            }
            queue = nextQueue;
            result.add(level);
        }

        return result;
    }

}
