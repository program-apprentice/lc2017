package com.programapprentice.app.medium;

import com.programapprentice.app.model.TreeNode;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal_314 {
    /**
     https://leetcode.com/problems/binary-tree-vertical-order-traversal/description/
     Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

     If two nodes are in the same row and column, the order should be from left to right.

     Examples:

     Given binary tree [3,9,20,null,null,15,7],
        3
       /\
      /  \
     9  20
       /\
      /  \
     15   7
     return its vertical order traversal as:
     [
     [9],
     [3,15],
     [20],
     [7]
     ]
     Given binary tree [3,9,8,4,0,1,7],
          3
         /\
        /  \
       9   8
       /\  /\
      /  \/  \
     4   01   7
     return its vertical order traversal as:
     [
     [4],
     [9],
     [3,0,1],
     [8],
     [7]
     ]
     Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
        3
        /\
       /  \
       9   8
      /\  /\
     /  \/  \
     4  01   7
       /\
      /  \
     5   2
     return its vertical order traversal as:
     [
     [4],
     [9,5],
     [3,0,1],
     [8,2],
     [7]
     ]

     * */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        HashMap<Integer, List<Integer>> posToValueMap = new HashMap<Integer, List<Integer>>();
        visit(root, posToValueMap);

        List<Integer> positions = new ArrayList<Integer>();
        positions.addAll(posToValueMap.keySet());
        Collections.sort(positions);

        for(Integer pos : positions) {
            result.add(posToValueMap.get(pos));
        }
        return result;
    }

    public void visit(TreeNode root, HashMap<Integer, List<Integer>> posToValueMap) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Integer> positions = new LinkedList<Integer>();
        queue.add(root);
        positions.add(0);
        while(!queue.isEmpty()) {
            TreeNode curNode = queue.remove();
            int pos = positions.remove();
            List<Integer> record = posToValueMap.get(pos);
            record = record == null ? new ArrayList<Integer>() : record;
            record.add(curNode.val);
            posToValueMap.put(pos, record);
            if(curNode.left != null) {
                queue.add(curNode.left);
                positions.add(pos - 1);
            }
            if(curNode.right != null) {
                queue.add(curNode.right);
                positions.add(pos + 1);
            }
        }
    }

}
