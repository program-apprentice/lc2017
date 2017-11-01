package com.programapprentice.app.facebook.easy;

import com.programapprentice.app.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LowestComonAncestorOfABinarySearchTree_235 {
    /**
     [235] Lowest Common Ancestor of a Binary Search Tree

     https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree

     Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
     According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

                   _______6______
                  /              \
              ___2__          ___8__
             /      \        /      \
            0      _4       7       9
          /  \
         3   5

     For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
     * */
    public List<TreeNode> getAncestors(TreeNode root, TreeNode p) {
        List<TreeNode> ancestors = new ArrayList<TreeNode>();
        TreeNode r = root;
        while(r != null) {
            ancestors.add(r);
            if (p.val > r.val) {
                r = r.right;
            } else if (p.val < r.val) {
                r = r.left;
            } else {
                return ancestors;
            }

        }
        return ancestors;
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
