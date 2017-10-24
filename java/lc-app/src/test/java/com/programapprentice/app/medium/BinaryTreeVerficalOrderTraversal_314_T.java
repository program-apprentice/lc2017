package com.programapprentice.app.medium;

import com.programapprentice.app.model.TreeNode;
import org.junit.Test;

public class BinaryTreeVerficalOrderTraversal_314_T {
    BinaryTreeVerticalOrderTraversal_314 solution = new BinaryTreeVerticalOrderTraversal_314();

    @Test
    public void test1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        solution.verticalOrder(root);
    }
}
