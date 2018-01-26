package com.programapprentice.app.google.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RedundantConnectionII_685 {
    /**
     In this problem, a rooted tree is a directed graph such that, there is exactly one node
     (the root) for which all other nodes are descendants of this node, plus every node has exactly
     one parent, except for the root node which has no parents.

     The given input is a directed graph that started as a rooted tree with N nodes (with distinct
     values 1, 2, ..., N), with one additional directed edge added. The added edge has two different
     vertices chosen from 1 to N, and was not an edge that already existed.

     The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] that
     represents a directed edge connecting nodes u and v, where u is a parent of child v.

     Return an edge that can be removed so that the resulting graph is a rooted tree of N nodes.
      If there are multiple answers, return the answer that occurs last in the given 2D-array.

     Example 1:
     Input: [[1,2], [1,3], [2,3]]
     Output: [2,3]
     Explanation: The given directed graph will be like this:
       1
      / \
     v   v
     2-->3
     Example 2:
     Input: [[1,2], [2,3], [3,4], [4,1], [1,5]]
     Output: [4,1]
     Explanation: The given directed graph will be like this:
     5 <- 1 -> 2
     ^    |
     |    v
     4 <- 3
     Note:
     The size of the input 2D-array will be between 3 and 1000.
     Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.

     Solution:
     http://zxi.mytechroad.com/blog/graph/leetcode-685-redundant-connection-ii/
     * */


    public int[] findRedundantDirectedConnection(int[][] edges) {
        Map<Integer, Integer> childToParentMap = new HashMap<Integer, Integer>();
        boolean hasTwoParent = false;
        int[] edge1 = new int[2];
        int[] edge2 = new int[2];
        for(int[] edge : edges) {
            int child = edge[1];
            int parent = edge[0];
            if (childToParentMap.containsKey(child)) {
                edge1[0] = childToParentMap.get(child);
                edge1[1] = child;
                edge2[0] = parent;
                edge2[1] = child;
                hasTwoParent = true;
            } else {
                childToParentMap.put(child, parent);
            }
        }

        if (!hasTwoParent) {
            return findCircle(edges);
        }
        int parent1 = edge1[0];
        if (isInCircle(parent1, childToParentMap)) {
            return edge1;
        }
        int parent2 = edge2[0];
        if (isInCircle(parent2, childToParentMap)) {
            return edge2;
        }
        return null;
    }

    public int[] findCircle(int[][] edges) {
        Map<Integer, Integer> childToParentMap = new HashMap<Integer, Integer>();
        int[] edge1 = new int[2];
        int[] edge2 = new int[2];
        for(int[] edge : edges) {
            int child = edge[1];
            int parent = edge[0];
            if (isInCircle(parent, childToParentMap)) {
                return edge;
            }
        }
        return null;
    }

    public boolean isInCircle(Integer parent, Map<Integer, Integer> childToParentMap) {
        Set<Integer> visited = new HashSet<Integer>();
        visited.add(parent);
        while(parent != null) {
            parent = childToParentMap.get(parent);
            if (parent != null && visited.contains(parent)) {
                return true;
            }
            visited.add(parent);

        }
        return false;
    }
}

