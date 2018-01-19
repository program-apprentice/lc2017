package com.programapprentice.app.google.medium;

import com.programapprentice.app.model.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeLongestConsecutiveSequence_298_T {
    BinaryTreeLongestConsecutiveSequence_298 solution = new BinaryTreeLongestConsecutiveSequence_298();

    @Test
    public void test1() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);
        int actual = solution.longestConsecutive(root);
        Assert.assertEquals(3, actual);
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.left.left= new TreeNode(1);
        int actual = solution.longestConsecutive(root);
        Assert.assertEquals(2, actual);
    }

    @Test
    public void test3() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        int actual = solution.longestConsecutive(root);
        Assert.assertEquals(2, actual);
    }
}
