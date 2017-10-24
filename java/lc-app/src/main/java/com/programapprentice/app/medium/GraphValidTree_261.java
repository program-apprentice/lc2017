package com.programapprentice.app.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphValidTree_261 {
    /**
     https://leetcode.com/problems/graph-valid-tree/description/
     Given n nodes labeled from 0 to n - 1 and a list of undirected edges
     (each edge is a pair of nodes), write a function to check whether these edges
     make up a valid tree.

     For example:
     Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
     Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

     Note: you can assume that no duplicate edges will appear in edges.
     Since all edges are undirected, [0, 1] is the same as [1, 0]
     and thus will not appear together in edges.
     * */
    /**
     * Two conditions to tell whether it's a tree:
     * 1. No circle
     * 2. No single point
     * */

    public boolean hasCircle(int n, List<List<Integer>> graph) {
        int[] visited = new int[n];
        int[] father = new int[n];
        for(int i = 0; i < n; i++) {
            father[i] = -1;
        }
        for(int startNode = 0; startNode <n; startNode++) {
            if (visited[startNode] == 0) {
                if (!dfs(n, startNode, visited, father, graph)) {
                    return true;
                }
            }
        }
        return false;
    }

    // return false, if there's a circle
    private boolean dfs(int numOfNodes, int startNode, int[] visited, int[] father, List<List<Integer>> graph) {
        visited[startNode] = 1;
        for(int i : graph.get(startNode)) {
            if (visited[i] == 1 && i != father[startNode]) {
                int tmp = startNode;
                return false;
            } else if (visited[i] == 0) {
                father[i] = startNode;
                dfs(numOfNodes, i, visited, father, graph);
            }
        }
        visited[startNode] = 2;// All neighbour are traversed.
        return true;
    }

    public boolean isAllConnected(int n, List<List<Integer>> graph) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(0);
        while(!queue.isEmpty()) {
            int curNode = queue.remove();
            visited[curNode] = true;
            for(Integer nextNode : graph.get(curNode)) {
                if (!visited[nextNode]) {
                    queue.add(nextNode);
                }
            }
        }

        boolean result = true;
        for(int i = 0; i < n; i++) {
            result  = result && visited[i];
        }
        return result;
    }

    public boolean validTree(int n, int[][] edges) {
        if (n <= 1) {
            return true;
        }
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        return !hasCircle(n, graph) && isAllConnected(n, graph);
    }
}
