package com.programapprentice.app.facebook.easy;


import com.programapprentice.app.model.TreeNode;
import org.junit.Test;

public class InvertBinaryTree_226_T {
    InvertBinaryTree_226 solution = new InvertBinaryTree_226();
    @Test
    public void test1() {
        TreeNode node = new TreeNode(1);
        TreeNode nnode = solution.invertTree(node);
    }
}
