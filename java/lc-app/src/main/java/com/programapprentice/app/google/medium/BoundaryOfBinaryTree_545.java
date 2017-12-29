package com.programapprentice.app.google.medium;

import com.programapprentice.app.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BoundaryOfBinaryTree_545 {
    /**
     https://leetcode.com/problems/boundary-of-binary-tree/description/
     Given a binary tree, return the values of its boundary in anti-clockwise direction starting from root.
     Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.

     Left boundary is defined as the path from root to the left-most node. Right boundary is defined as
     the path from root to the right-most node. If the root doesn't have left subtree or right subtree,
     then the root itself is left boundary or right boundary. Note this definition only applies to the
     input binary tree, and not applies to any subtrees.

     The left-most node is defined as a leaf node you could reach when you always firstly travel to the
     left subtree if exists. If not, travel to the right subtree. Repeat until you reach a leaf node.

     The right-most node is also defined by the same way with left and right exchanged.

     Example 1
     Input:
      1
       \
       2
      / \
     3   4

     Ouput:
     [1, 3, 4, 2]

     Explanation:
     The root doesn't have left subtree, so the root itself is left boundary.
     The leaves are node 3 and 4.
     The right boundary are node 1,2,4. Note the anti-clockwise direction means you should output reversed
     right boundary.
     So order them in anti-clockwise without duplicates and we have [1,3,4,2].
     Example 2
     Input:
           ____1_____
          /          \
         2            3
        / \          /
       4   5        6
          / \      / \
         7   8    9  10

     Ouput:
     [1,2,4,7,8,9,10,6,3]

     Explanation:
     The left boundary are node 1,2,4. (4 is the left-most node according to definition)
     The leaves are node 4,7,8,9,10.
     The right boundary are node 1,3,6,10. (10 is the right-most node).
     So order them in anti-clockwise without duplicate nodes we have [1,2,4,7,8,9,10,6,3].

     Solution:
     http://www.cnblogs.com/grandyang/p/6833459.html
     * */
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        if (root.left != null || root.right != null) {
            result.add(root.val);
        }
        leftBoundary(root.left, result);
        leaves(root, result);
        rightBoundary(root.right, result);
        return result;
    }

    private boolean isLeave(TreeNode node) {
        return node.left == null && node.right == null;
    }
    private void leftBoundary(TreeNode node, List<Integer> result) {
        if (node == null || isLeave(node)) {
            return;
        }
        result.add(node.val);
        if (node.left == null) {
            leftBoundary(node.right, result);
        } else {
            leftBoundary(node.left, result);
        }
    }

    private void rightBoundary(TreeNode node, List<Integer> result) {
        if (node == null || isLeave(node)) {
            return;
        }
        if (node.right == null) {
            rightBoundary(node.left, result);
        } else {
            rightBoundary(node.right, result);
        }
        result.add(node.val);
    }

    private void leaves(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        if (isLeave(node)) {
            result.add(node.val);
        }
        leaves(node.left, result);
        leaves(node.right, result);
    }
}
