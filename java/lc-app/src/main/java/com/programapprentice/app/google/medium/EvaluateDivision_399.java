package com.programapprentice.app.google.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class EvaluateDivision_399 {
    /**
     https://leetcode.com/problems/evaluate-division/description/
     Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real
     number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

     Example:
     Given a / b = 2.0, b / c = 3.0.
     queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
     return [6.0, 0.5, -1.0, 1.0, -1.0 ].

     The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries ,
     where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

     According to the example above:

     equations = [ ["a", "b"], ["b", "c"] ],
     values = [2.0, 3.0],
     queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
     The input is always valid. You may assume that evaluating the queries will result in no division by zero and
     there is no contradiction.
     * */
    class Node {
        String node;
        Double weight;

        public Node(String node, Double weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public double getResult(Map<String, Map<String, Double>> graph, String[] query) {
        if (!graph.containsKey(query[0]) || !graph.containsKey(query[1])) {
            return -1.0;
        }
        Queue<Node> queue = new LinkedList<Node>();
        Queue<Set<String>> visited = new LinkedList<Set<String>>();
        Node node = new Node(query[0], 1.0);
        Set<String> history = new HashSet<String>();
        history.add(query[0]);
        visited.add(new HashSet<String>());
        queue.add(node);
        while(!queue.isEmpty()) {
            Node cur = queue.remove();
            history = visited.remove();
            if (cur.node.equals(query[1])) {
                return cur.weight;
            }
            Map<String, Double> neighbour = graph.get(cur.node);
            for(String key : neighbour.keySet()) {
                if (history.contains(key)) {
                    continue;
                }
                Double value = neighbour.get(key);
                queue.add(new Node(key, cur.weight * value));
                Set<String> newHistory = new HashSet<String>(history);
                newHistory.add(key);
                visited.add(newHistory);
            }
        }
        return -1.0;
    }

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> graph = new HashMap<String, Map<String, Double>>();
        int numOfEdges = equations.length;
        for(int i = 0; i < numOfEdges; i++) {
            String start = equations[i][0];
            String end = equations[i][1];
            double value = values[i];
            Map<String, Double> startNeighbour = graph.get(start) == null ? new HashMap<String, Double>() : graph.get(start);
            Map<String, Double> endNeighbour = graph.get(end) == null ? new HashMap<String, Double>() : graph.get(end);
            startNeighbour.put(end, value);
            endNeighbour.put(start, 1/value);
            graph.put(start, startNeighbour);
            graph.put(end, endNeighbour);
        }

        int numOfQueries = queries.length;
        double[] result = new double[numOfQueries];
        for(int i = 0; i < numOfQueries; i++) {
            String[] query = queries[i];
            result[i] = getResult(graph, query);
        }

        return result;
    }
}
