package com.programapprentice.app.google.easy;

import com.programapprentice.app.model.TreeNode;

import java.util.Stack;

public class MinimumAbsoluteDifferenceInBST_530 {
    /**
     https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/
     * */
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        TreeNode pre = null;
        int min = Integer.MAX_VALUE;
        while(!stack.isEmpty() || p != null) {
            while(p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if (pre != null) {
                min = Math.min(min, Math.abs(p.val - pre.val));
            }
            pre = p;
            p = p.right;
        }
        return min;
    }
}
