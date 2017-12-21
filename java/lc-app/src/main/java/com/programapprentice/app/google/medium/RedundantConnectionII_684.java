package com.programapprentice.app.google.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RedundantConnectionII_684 {
    /**
     * https://leetcode.com/problems/redundant-connection/description/
     * In this problem, a tree is an undirected graph that is connected and has no cycles.
     * <p>
     * The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N),
     * with one additional edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.
     * <p>
     * The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v,
     * that represents an undirected edge connecting nodes u and v.
     * <p>
     * Return an edge that can be removed so that the resulting graph is a tree of N nodes.
     * If there are multiple answers, return the answer that occurs last in the given 2D-array.
     * The answer edge [u, v] should be in the same format, with u < v.
     * <p>
     * Example 1:
     * Input: [[1,2], [1,3], [2,3]]
     * Output: [2,3]
     * Explanation: The given undirected graph will be like this:
     * 1
     * / \
     * 2 - 3
     * Example 2:
     * Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
     * Output: [1,4]
     * Explanation: The given undirected graph will be like this:
     * 5 - 1 - 2
     * |   |
     * 4 - 3
     * Note:
     * The size of the input 2D-array will be between 3 and 1000.
     * Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.
     * <p>
     * Update (2017-09-26):
     * We have overhauled the problem description + test cases and specified clearly the graph is an undirected graph.
     * For the directed graph follow up please see Redundant Connection II). We apologize for any inconvenience caused.
     * <p>
     * <p>
     * Solution:
     * http://zxi.mytechroad.com/blog/tree/leetcode-684-redundant-connection/
     * 并查集
     */

    public int[] findRedundantConnectionDFS(int[][] edges) {
        if (edges == null || edges.length == 0 || edges[0].length == 0) {
            return new int[0];
        }
        int numOfNodes = edges.length;
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();

        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            boolean[] visited = new boolean[numOfNodes];
            if (hasPath(start, end, graph, visited)) {
                return edge;
            }
            List<Integer> neighbours = graph.get(start) == null ? new ArrayList<Integer>() : graph.get(start);
            neighbours.add(end);
            graph.put(start, neighbours);
            neighbours = graph.get(end) == null ? new ArrayList<Integer>() : graph.get(end);
            neighbours.add(start);
            graph.put(end, neighbours);
        }
        return new int[0];
    }

    public boolean hasPath(int current, int goal, Map<Integer, List<Integer>> graph, boolean[] visited) {
        if (current == goal) {
            return true;
        }
        visited[current - 1] = true;
        if (graph.get(current) == null || graph.get(current).size() == 0
                || graph.get(goal) == null || graph.get(goal).size() == 0) {
            return false;
        }
        for (int next : graph.get(current)) {
            if (visited[next - 1]) {
                continue;
            }
            if (hasPath(next, goal, graph, visited)) {
                return true;
            }
        }
        return false;
    }

    // Union find Solution
    /////////////////////////////////////////////////////////////////////////////////
    class UnionFindSet {
        private int[] parents;
        private int[] ranks;

        public UnionFindSet(int n) {
            parents = new int[n+1];
            ranks = new int[n+1];
            for (int i = 0; i <= n; i++) {
                parents[i] = i;
                ranks[i] = 1;
            }
        }

        public boolean union(int u, int v) {
            int pu = find(u);
            int pv = find(v);
            if (pu == pv) {
                return false;
            }
            if (ranks[pv] > ranks[pu]) {
                parents[pu] = pv;
            } else if (ranks[pu] > ranks[pv]) {
                parents[pv] = pu;
            } else {
                parents[pv] = pu;
                ranks[pu] += 1;
            }
            return true;
        }

        public int find(int u) {
            while(parents[u] != u) {
                parents[u] = parents[parents[u]];
                u = parents[u];
            }
            return u;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        UnionFindSet unionFindSet = new UnionFindSet(edges.length);
        for(int[] edge : edges) {
            if (!unionFindSet.union(edge[0], edge[1])) {
                return edge;
            }
        }
        return null;
    }
}