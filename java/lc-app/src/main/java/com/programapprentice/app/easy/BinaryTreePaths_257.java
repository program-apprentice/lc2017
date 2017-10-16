package com.programapprentice.app.easy;

import com.programapprentice.app.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_257 {
    /**
     [257] Binary Tree Paths

     https://leetcode.com/problems/binary-tree-paths

     Given a binary tree, return all root-to-leaf paths.

     For example, given the following binary tree:

        1
      /   \
     2     3
     \
     5

     All root-to-leaf paths are:
     ["1->2->5", "1->3"]
     * */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if (root == null) {
            return result;
        }
        List<TreeNode> q = new ArrayList<TreeNode>();
        List<String> ancestors = new ArrayList<String>();
        q.add(root);
        ancestors.add(String.format("%d", root.val));
        while (!q.isEmpty()) {
            int size = q.size();
            List<TreeNode> newLevel = new ArrayList<TreeNode>();
            List<String> newAncesters = new ArrayList<String>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.get(i);
                String ancestor = ancestors.get(i);
                if (node.left == null && node.right == null) { // leaf node
                    result.add(ancestor);
                }
                if(node.left != null) {
                    newLevel.add(node.left);
                    newAncesters.add(String.format("%s->%d", ancestor, node.left.val));
                }
                if(node.right != null) {
                    newLevel.add(node.right);
                    newAncesters.add(String.format("%s->%d", ancestor, node.right.val));
                }
            }
            q = newLevel;
            ancestors = newAncesters;
        }

        return result;
    }
}
