package com.programapprentice.app.facebook.medium;

import com.programapprentice.app.model.TreeLinkNode;
import org.junit.Test;

public class PopulatingNextRightPointersinEachNodeII_117_T {
    PopulatingNextRightPointersInEachNodeII_117 solution = new PopulatingNextRightPointersInEachNodeII_117();

    @Test
    public void test1() {
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.right.right = new TreeLinkNode(5);
        solution.connect(root);
    }
}
