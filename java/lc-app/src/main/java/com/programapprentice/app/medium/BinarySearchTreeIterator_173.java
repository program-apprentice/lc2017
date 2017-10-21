package com.programapprentice.app.medium;

import com.programapprentice.app.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeIterator_173 {
    /**
     [173] Binary Search Tree Iterator

     https://leetcode.com/problems/binary-search-tree-iterator

     Implement an iterator over a binary search tree (BST). Your iterator will be initialized
     with the root node of a BST.

     Calling next() will return the next smallest number in the BST.

     Note: next() and hasNext() should run in average O(1) time and uses O(h) memory,
     where h is the height of the tree.
     * */
    /**
     * Your BSTIterator will be called like this:
     * BSTIterator i = new BSTIterator(root);
     * while (i.hasNext()) v[f()] = i.next();
     */

    public class BSTIterator {
        List<TreeNode> queue = new ArrayList<TreeNode>();
        int idx = 0;

        public BSTIterator(TreeNode root) {
            this.midOrder(root, queue);
        }

        public void midOrder(TreeNode root, List<TreeNode> queue) {
            if(root == null) {
                return;
            }
            if (root.left != null) {
                midOrder(root.left, queue);
            }
            queue.add(root);
            if (root.right != null) {
                midOrder(root.right, queue);
            }
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            if (idx == queue.size()) {
                return false;
            }
            return true;
        }

        /** @return the next smallest number */
        public int next() {
            int val = queue.get(idx).val;
            idx++;
            return val;
        }
    }




}
