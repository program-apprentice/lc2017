package com.programapprentice.app.easy;

import com.programapprentice.app.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AvarageOfLevelsInBinaryTree_637 {
    /**
     [637] Average of Levels in Binary Tree

     https://leetcode.com/problems/average-of-levels-in-binary-tree

     Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.

     Example 1:

     Input:
        3
       / \
      9  20
      /  \
     15   7
     Output: [3, 14.5, 11]
     Explanation:
     The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].

     Note:

     The range of node's value is in the range of 32-bit signed integer.
     * */

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<Double>();
        if (root == null) {
            return result;
        }
        List<TreeNode> q = new ArrayList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {
            double sum = 0;
            int size = q.size();
            List<TreeNode> newLevel = new ArrayList<TreeNode>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.get(i);
                if(node.left != null) {
                    newLevel.add(node.left);
                }
                if(node.right != null) {
                    newLevel.add(node.right);
                }
                sum += (double) node.val;
            }
            result.add(sum/ (double)size);
            q = newLevel;
        }

        return result;
    }
}
