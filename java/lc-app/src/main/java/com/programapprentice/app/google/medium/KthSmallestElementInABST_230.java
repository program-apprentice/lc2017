package com.programapprentice.app.google.medium;

import com.programapprentice.app.model.TreeNode;

public class KthSmallestElementInABST_230 {
    /**
     https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
     Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

     Note:
     You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

     Follow up:
     What if the BST is modified (insert/delete operations) often and you need to find the
     kth smallest frequently? How would you optimize the kthSmallest routine?
     * */
    Integer r = null;
    Integer idx = 0;

    public int kthSmallest(TreeNode root, int k) {
        idx = 0;
        travel(root, k);
        return r.intValue();
    }

    void travel(TreeNode root, int k ) {
        if(root == null && r != null) return;
        if(root.left != null) {
            travel(root.left, k);
        }
        idx++;
        if(idx == k) {
            r = root.val;
        }
        if(root.right != null) {
            travel(root.right, k);
        }
    }
}
