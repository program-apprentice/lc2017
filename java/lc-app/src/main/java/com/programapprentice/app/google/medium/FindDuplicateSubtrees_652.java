package com.programapprentice.app.google.medium;

import com.programapprentice.app.model.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees_652 {
    /**
     https://leetcode.com/problems/find-duplicate-subtrees/description/
     Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.

     Two trees are duplicate if they have the same structure with same node values.

     Example 1:
          1
         / \
        2   3
       /   / \
      4   2   4
         /
        4
     The following are two duplicate subtrees:
       2
      /
     4
     and
     4
     Therefore, you need to return above trees' root in the form of a list.
     * */

    private String helper(TreeNode root, Map<String, Integer> treeToNumberMap, List<TreeNode> duplicates) {
        if (root == null) {
            return "#";
        }
        String left = helper(root.left, treeToNumberMap, duplicates);
        String right = helper(root.right, treeToNumberMap, duplicates);
        String cur = Integer.toString(root.val) + "," +  left + "," + right;
        Integer counter = treeToNumberMap.get(cur);
        if (counter == null) {
            treeToNumberMap.put(cur, 1);
        } else if (counter == 1) {
            duplicates.add(root);
            treeToNumberMap.put(cur, counter + 1);
        } else {
            treeToNumberMap.put(cur, counter + 1);
        }
        return cur;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> treeToNumberMap = new HashMap<String, Integer>();
        List<TreeNode> result = new ArrayList<TreeNode>();
        helper(root, treeToNumberMap, result);
        return result;
    }
}
