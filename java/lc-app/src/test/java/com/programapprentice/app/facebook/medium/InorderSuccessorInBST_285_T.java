package com.programapprentice.app.facebook.medium;

import com.programapprentice.app.model.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class InorderSuccessorInBST_285_T {
    InorderSuccessorInBST_285 solution = new InorderSuccessorInBST_285();

    @Test
    public void test1() {
        TreeNode root = new TreeNode(0);
        TreeNode p = root;
        TreeNode result = solution.inorderSuccessor(root, p);
        Assert.assertEquals(null, result);
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        root.left = left;
        TreeNode p = left;
        TreeNode result = solution.inorderSuccessor(root, p);
        Assert.assertEquals(2, result.val);
    }
}
