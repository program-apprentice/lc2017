package com.programapprentice.app.medium;

import com.programapprentice.app.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LowestComonAncestorOfABinaryTree_236 {
    /**
     [236] Lowest Common Ancestor of a Binary Tree

     https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree

     Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

     According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

              _______3______
             /              \
          ___5__          ___1__
         /      \        /      \
        6      _2       0       8
      /  \
     7   4

     For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

     * */
    public List<TreeNode> getAncestors(TreeNode root, TreeNode p) {
        List<List<TreeNode>> parents = new ArrayList<List<TreeNode>>();
        parents.add(new ArrayList<TreeNode>());
        List<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            List<TreeNode> newQueue = new ArrayList<TreeNode>();
            List<List<TreeNode>> newParents = new ArrayList<List<TreeNode>>();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode curNode = queue.get(i);
                List<TreeNode> ancestors = parents.get(i);
                ancestors.add(curNode);
                if (curNode == p) {
                    return ancestors;
                }
                if (curNode.left != null) {
                    newQueue.add(curNode.left);
                    newParents.add(new ArrayList<TreeNode>(ancestors));
                }
                if (curNode.right != null) {
                    newQueue.add(curNode.right);
                    newParents.add(new ArrayList<TreeNode>(ancestors));
                }
            }
            queue = newQueue;
            parents = newParents;
        }

        return new ArrayList<TreeNode>();
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pAncestors = getAncestors(root, p);
        List<TreeNode> qAncestors = getAncestors(root, q);
        int len = Math.min(pAncestors.size(), qAncestors.size());
        for(int i = 0; i < len; i++) {
            TreeNode pa = pAncestors.get(i);
            TreeNode qa = qAncestors.get(i);
            if (pa.val != qa.val) {
                return pAncestors.get(i-1);
            }
        }
        if (len == 0) {
            return root;
        }
        return pAncestors.get(len-1);
    }
}
