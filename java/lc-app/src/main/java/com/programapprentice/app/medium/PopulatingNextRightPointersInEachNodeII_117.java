package com.programapprentice.app.medium;

import com.programapprentice.app.model.TreeLinkNode;

import java.util.ArrayList;
import java.util.List;

public class PopulatingNextRightPointersInEachNodeII_117 {
    /**
     [117] Populating Next Right Pointers in Each Node II

     https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii

     Follow up for problem "Populating Next Right Pointers in Each Node".
     What if the given tree could be any binary tree? Would your previous solution still work?

     Note:
     You may only use constant extra space.

     For example,
     Given the following binary tree,

         1
        /  \
       2    3
      / \    \
     4   5    7

     After calling your function, the tree should look like:

          1 -> NULL
         /  \
        2 -> 3 -> NULL
       / \    \
     4-> 5 -> 7 -> NULL
     * */

    public void connect(TreeLinkNode root) {
        List<TreeLinkNode> queue = new ArrayList<TreeLinkNode>();
        if (root == null) {
            return;
        }
        queue.add(root);
        while(!queue.isEmpty()) {
            List<TreeLinkNode> nextQueue = new ArrayList<TreeLinkNode>();
            TreeLinkNode cur = null;
            for(int i = 0; i < queue.size(); i++) {
                cur = queue.get(i);
                if (i == queue.size()-1) {
                    cur.next = null;
                } else {
                    cur.next = queue.get(i+1);
                }
                if (cur.left != null) {
                    nextQueue.add(cur.left);
                }
                if (cur.right != null) {
                    nextQueue.add(cur.right);
                }
            }
            queue = nextQueue;
        }
    }

}
