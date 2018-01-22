package com.programapprentice.app.google.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GraphValidTree_261 {
    /**
     https://leetcode.com/problems/graph-valid-tree/description/
     Given n nodes labeled from 0 to n - 1 and a list of undirected edges
     (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

     For example:

     Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

     Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

     Note: you can assume that no duplicate edges will appear in edges.
     Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
     * */
    // This solution is wrong
    // Please see solution from facebook package

    public boolean validTree(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();

        for(int[] edge : edges) {
            Set<Integer> neighbours = graph.get(edge[0]) == null ? new HashSet<Integer>() : graph.get(edge[0]);
            neighbours.add(edge[1]);
            graph.put(edge[0], neighbours);
            neighbours = graph.get(edge[1]) == null ? new HashSet<Integer>() : graph.get(edge[1]);
            neighbours.add(edge[0]);
            graph.put(edge[1], neighbours);
        }
        Set<Integer> treeNodes = new HashSet<Integer>();
        while(treeNodes.size() != n) {
            Set<Integer> leaf = new HashSet<Integer>();
            for(int node : graph.keySet()) {
                Set<Integer> neighbours = graph.get(node);
                for(Integer visit : treeNodes) {
                    if (neighbours.contains(visit)) {
                        neighbours.remove(visit);
                    }
                }
                if (neighbours.size() == 1) {
                    leaf.add(node);
                }
            }
            if (leaf.isEmpty()) {
                if (treeNodes.size() == n) {
                    return true;
                }
                return false;
            }
            treeNodes.addAll(leaf);
            for(Integer l : leaf) {
                graph.remove(l);
            }
        }
        return true;
    }
}
