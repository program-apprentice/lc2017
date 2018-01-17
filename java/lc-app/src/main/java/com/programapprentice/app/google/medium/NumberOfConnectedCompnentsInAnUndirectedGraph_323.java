package com.programapprentice.app.google.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class NumberOfConnectedCompnentsInAnUndirectedGraph_323 {
    /**
     https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
     Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.
     Example 1:
     0          3
     |          |
     1 --- 2    4
     Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
     Example 2:
     0           4
     |           |
     1 --- 2 --- 3
     Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.
     * */

    public int countComponents(int n, int[][] edges) {
        if (edges == null || edges.length == 0 || edges[0] == null || edges[0].length == 0) {
            return n;
        }
        Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
        int result = 0;
        int node1 = 0, node2;
        for(int[] edge : edges) {
            node1 = edge[0];
            node2 = edge[1];
            Set<Integer> neighbours1 = graph.get(node1) == null ? new HashSet<Integer>() : graph.get(node1);
            neighbours1.add(node2);
            graph.put(node1, neighbours1);
            Set<Integer> neighbours2 = graph.get(node2) == null ? new HashSet<Integer>() : graph.get(node2);
            neighbours2.add(node1);
            graph.put(node2, neighbours2);
        }
        Set<Integer> visited = new HashSet<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        while(visited.size() != graph.keySet().size()) {
            if (queue.isEmpty()) {
               result++;
               for(int key : graph.keySet()) {
                   if (!visited.contains(key)) {
                       queue.add(key);
                       break;
                   }
               }
               continue;
            }
            int node = queue.remove();
            visited.add(node);
            Set<Integer> neighbours = graph.get(node);
            for(int neighbour : neighbours) {
                if (!visited.contains(neighbour)) {
                    queue.add(neighbour);
                }
            }
        }
        if (visited.size() != n) {
            result += (n - visited.size());
        }
        return result;
    }
}
