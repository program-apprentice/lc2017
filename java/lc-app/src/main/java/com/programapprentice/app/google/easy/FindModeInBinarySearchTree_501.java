package com.programapprentice.app.google.easy;

import com.programapprentice.app.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindModeInBinarySearchTree_501 {
    /**
     https://leetcode.com/problems/find-mode-in-binary-search-tree/description/
     Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

     Assume a BST is defined as follows:

     The left subtree of a node contains only nodes with keys less than or equal to the node's key.
     The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
     Both the left and right subtrees must also be binary search trees.
     For example:
     Given BST [1,null,2,2],
      1
       \
       2
      /
     2
     return [2].

     Note: If a tree has more than one mode, you can return them in any order.

     Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count)
     * */
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        int max = 0;
        int count = 1;
        TreeNode p = root;
        TreeNode pre = null;
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if (pre != null) {
                count = pre.val == p.val ? count+1 : 1;
            }
            if (count >= max) {
                if (count > max) {
                    result = new ArrayList<Integer>();
                }
                result.add(p.val);
                max = count;
            }
            pre = p;
            p = p.right;
        }
        int[] array = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            array[i] = result.get(i);
        }
        return array;
    }
}
